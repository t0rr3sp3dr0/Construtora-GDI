package systems.singularity.buildware.gui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.db.Repositories;
import systems.singularity.buildware.enums.Bank;
import systems.singularity.buildware.models.*;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.ComboBoxAutoComplete;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * Created by pedro on 4/25/16.
 * © 2016 Singularity Systems
 */
public class FornecedoresCadastroController implements Initializable {
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="nameFornecedorTextField"
    private TextField nameFornecedorTextField; // Value injected by FXMLLoader

    @FXML // fx:id="cnpjFornecedorTableColumn"
    private TableColumn<Provider, String> cnpjFornecedorTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="emailFornecedorTableColumn"
    private TableColumn<Provider, String> emailFornecedorTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="addFornecedorButton"
    private Button addFornecedorButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveFornecedorButton"
    private Button saveFornecedorButton; // Value injected by FXMLLoader

    @FXML // fx:id="deleteFornecedorButton"
    private Button deleteFornecedorButton; // Value injected by FXMLLoader

    @FXML // fx:id="searchFornecedorTextField"
    private TextField searchFornecedorTextField; // Value injected by FXMLLoader

    @FXML // fx:id="agencyAccountFornecedorTextField"
    private TextField agencyAccountFornecedorTextField; // Value injected by FXMLLoader

    @FXML // fx:id="editFornecedorButton"
    private Button editFornecedorButton; // Value injected by FXMLLoader

    @FXML // fx:id="cnpjFornecedorTextField"
    private TextField cnpjFornecedorTextField; // Value injected by FXMLLoader

    @FXML // fx:id="bankAccountFornecedorComboBox"
    private ComboBox<Bank> bankAccountFornecedorComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="numberAccountFornecedorTextField"
    private TextField numberAccountFornecedorTextField; // Value injected by FXMLLoader

    @FXML // fx:id="fornecedoresTableView"
    private TableView<Provider> fornecedoresTableView; // Value injected by FXMLLoader

    @FXML // fx:id="fornecedorTableColumn"
    private TableColumn<Provider, String> fornecedorTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="emailFornecedorTextField"
    private TextField emailFornecedorTextField; // Value injected by FXMLLoader

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //<editor-fold desc="fornecedor">
        refresh(null);

        fornecedorTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        cnpjFornecedorTableColumn.setCellValueFactory(new PropertyValueFactory<>("cNPJ"));
        emailFornecedorTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        SelectionModel<Provider> selectionModel = fornecedoresTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null)
                clearFields();
            else {
                nameFornecedorTextField.setText(newValue.getName());
                cnpjFornecedorTextField.setText(newValue.getCNPJ());
                emailFornecedorTextField.setText(newValue.getEmail());
                bankAccountFornecedorComboBox.getSelectionModel().select(newValue.getBankAccount().getBank());
                agencyAccountFornecedorTextField.setText(newValue.getBankAccount().getAgency());
                numberAccountFornecedorTextField.setText(newValue.getBankAccount().getNumber());
                setEditable(false);
            }
        });

        // TODO: Fix buttons' logic (enabled/disabled)
        addFornecedorButton.setOnAction(event -> {
            selectionModel.clearSelection();
            setEditable(true);
        });
        editFornecedorButton.setOnAction(event -> setEditable(true));
        saveFornecedorButton.setOnAction(event -> {
            setEditable(false);

            boolean newFornecedor = false;

            Provider provider = selectionModel.getSelectedItem();
            if (provider == null) {
                newFornecedor = true;
                provider = new Provider().bankAccount(new BankAccount());
            }

            provider.setName(nameFornecedorTextField.getText());
            provider.setCNPJ(cnpjFornecedorTextField.getText());
            provider.setEmail(emailFornecedorTextField.getText());
            provider.getBankAccount().setBank(bankAccountFornecedorComboBox.getValue());
            provider.getBankAccount().setAgency(agencyAccountFornecedorTextField.getText());
            provider.getBankAccount().setNumber(numberAccountFornecedorTextField.getText());

            try {
                if (newFornecedor) {
                    provider.getBankAccount().id(Repositories.bankAccount.insert(provider.getBankAccount()));
                    provider.id(Repositories.provider.insert(provider));
                } else {
                    Repositories.provider.update(provider);
                    Repositories.bankAccount.update(provider.getBankAccount());
                }
                refresh(provider);
            } catch (SQLException e) {
                StageTools.throwable(e, true);
                setEditable(true);
            }
        });
        deleteFornecedorButton.setOnAction(event -> {
            Provider provider = selectionModel.getSelectedItem();
            if (provider == null) {
                clearFields();
                setEditable(false);
            } else {
                try {
                    Repositories.provider.remove(provider.getId());
                    Repositories.bankAccount.remove(provider.getBankAccount().getId());
                    refresh(null);
                } catch (SQLException e) {
                    StageTools.throwable(e, true);
                }
            }

            selectionModel.clearSelection();
            setEditable(false);
        });

        clearFields();
        setEditable(false);
        //</editor-fold>

        //<editor-fold desc="bancosFornecedor">
        bankAccountFornecedorComboBox.setItems(FXCollections.observableArrayList(Bank.values()));
        new ComboBoxAutoComplete<>(bankAccountFornecedorComboBox);
        //</editor-fold>
    }

    //<editor-fold desc="fornecedoresTableView">

    public void refresh(Provider select) {
        Platform.runLater(() -> fornecedoresTableView.setDisable(true));

        new AsyncCallable(() -> {
            List<Provider> list = Repositories.provider.getAll().stream().map(provider -> {
                try {
                    return provider.bankAccount(Repositories.bankAccount.get(provider.getBankAccount().getId()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
            ObservableList<Provider> observableList = FXCollections.observableArrayList(list);
            FilteredList<Provider> filteredList = new FilteredList<>(observableList, customer -> true);
            SortedList<Provider> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(fornecedoresTableView.comparatorProperty());

            Platform.runLater(() -> {
                fornecedoresTableView.setItems(sortedList);
                searchFornecedorTextField.textProperty().addListener((observable, oldValue, newValue) -> filteredList.setPredicate(provider -> {
                    if (newValue == null || newValue.isEmpty())
                        return true;

                    String lowerCaseFilter = newValue.toLowerCase();
                    String replaceAll = newValue.replaceAll("\\D+", "");

                    // TODO: Amplify search to all parameters
                    if (lowerCaseFilter.length() > 0 && provider.getName().toLowerCase().contains(lowerCaseFilter))
                        return true;
                    else if (replaceAll.length() > 0 && provider.getCNPJ().replaceAll("\\D+", "").contains(replaceAll))
                        return true;
                    else if (lowerCaseFilter.length() > 0 && provider.getEmail().toLowerCase().contains(lowerCaseFilter))
                        return true;

                    return false;
                }));

                fornecedoresTableView.setDisable(false);
                fornecedoresTableView.getSelectionModel().select(select);
            });

            return null;
        }).start();
    }

    private void clearFields() {
        nameFornecedorTextField.setText("");
        cnpjFornecedorTextField.setText("");
        emailFornecedorTextField.setText("");
        bankAccountFornecedorComboBox.setValue(Bank._null);
        agencyAccountFornecedorTextField.setText("");
        numberAccountFornecedorTextField.setText("");
    }

    private void setEditable(boolean b) {
        nameFornecedorTextField.setEditable(b);
        cnpjFornecedorTextField.setEditable(b);
        emailFornecedorTextField.setEditable(b);
        bankAccountFornecedorComboBox.setDisable(!b);
        agencyAccountFornecedorTextField.setEditable(b);
        numberAccountFornecedorTextField.setEditable(b);
    }

    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
        addFornecedorButton.setDisable(add);
        editFornecedorButton.setDisable(edit);
        saveFornecedorButton.setDisable(save);
        deleteFornecedorButton.setDisable(delete);
    }
    //</editor-fold>
}
