package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.enums.Bank;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.models.BankAccount;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.Postmon;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class PrestadoresServicoCadastroController implements Initializable {
//    @FXML
//    private TableColumn<PrestadorServico, String> phonePrestadorServicoTableColumn;
//    @FXML
//    private TableColumn<PrestadorServico, String> emailPrestadorServicoTableColumn;
//    @FXML
//    private TextField namePrestadorServicoTextField;
//    @FXML
//    private TextField searchPrestadorServicoTextField;
//    @FXML
//    private TextField agencyAccountPrestadorServicoTextField;
//    @FXML
//    private TableColumn<PrestadorServico, String> prestadorServicoTableColumn;
//    @FXML
//    private TextField complementPrestadorServicoTextField;
//    @FXML
//    private TextField streetPrestadorServicoTextField;
//    @FXML
//    private TableView<PrestadorServico> prestadoresServicoTableView;
//    @FXML
//    private TextField numberAccountPrestadorServicoTextField;
//    @FXML
//    private Button editPrestadorServicoButton;
//    @FXML
//    private TextField statePrestadorServicoTextField;
//    @FXML
//    private TextField zipCodePrestadorServicoTextField;
//    @FXML
//    private TextField emailPrestadorServicoTextField;
//    @FXML
//    private TextField cityPrestadorServicoTextField;
//    @FXML
//    private TextField servicePrestadorServicoTextField;
//    @FXML
//    private Button addPrestadorServicoButton;
//    @FXML
//    private Button savePrestadorServicoButton;
//    @FXML
//    private TextField cPrestadorServicoTextField;
//    @FXML
//    private TextField neighborhoodPrestadorServicoTextField;
//    @FXML
//    private Button deletePrestadorServicoButton;
//    @FXML
//    private TableColumn<PrestadorServico, String> servicePrestadorServicoTableColumn;
//    @FXML
//    private ComboBox<Bank> bankAccountPrestadorServicoComboBox;
//    @FXML
//    private TextField ownerAccountPrestadorServicoTextField;
//    @FXML
//    private TextField cAccountPrestadorServicoTextField;
//    @FXML
//    private TextField phoneNumberPrestadorServicoTextField;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="prestadorServico">
//        new AsyncCallable(() -> {
//            prestadoresServicoTableView.setItems(FXCollections.observableArrayList(new PrestadoresServicoRepository().getAll()));
//            return null;
//        }).start();
//
//        prestadorServicoTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        servicePrestadorServicoTableColumn.setCellValueFactory(new PropertyValueFactory<>("service"));
//        phonePrestadorServicoTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        emailPrestadorServicoTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        SelectionModel selectionModel = prestadoresServicoTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null)
//                clearFields();
//            else {
//                PrestadorServico prestadorServico = (PrestadorServico) newValue;
//                Address prestadorServicoAddress = prestadorServico.getAddress();
//                BankAccount prestadorServicoAccount = prestadorServico.getBankAccount();
//
//                namePrestadorServicoTextField.setText(prestadorServico.getName());
//                servicePrestadorServicoTextField.setText(prestadorServico.getService());
//                cPrestadorServicoTextField.setText(prestadorServico.getC());
//                phoneNumberPrestadorServicoTextField.setText(prestadorServico.getPhoneNumber());
//                emailPrestadorServicoTextField.setText(prestadorServico.getEmail());
//                streetPrestadorServicoTextField.setText(prestadorServicoAddress.getStreet());
//                complementPrestadorServicoTextField.setText(prestadorServicoAddress.getComplement());
//                neighborhoodPrestadorServicoTextField.setText(prestadorServicoAddress.getNeighborhood());
//                cityPrestadorServicoTextField.setText(prestadorServicoAddress.getCity());
//                statePrestadorServicoTextField.setText(prestadorServicoAddress.getState());
//                zipCodePrestadorServicoTextField.setText(prestadorServicoAddress.getZipCode());
//                bankAccountPrestadorServicoComboBox.setValue(prestadorServicoAccount.getBank());
//                agencyAccountPrestadorServicoTextField.setText(prestadorServicoAccount.getAgency());
//                numberAccountPrestadorServicoTextField.setText(prestadorServicoAccount.getNumber());
//            }
//        });
//
//        Postmon.addListener(zipCodePrestadorServicoTextField, streetPrestadorServicoTextField, neighborhoodPrestadorServicoTextField, cityPrestadorServicoTextField, statePrestadorServicoTextField, null);
//
//        addPrestadorServicoButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//        editPrestadorServicoButton.setOnAction(event -> setEditable(true));
//        savePrestadorServicoButton.setOnAction(event -> {
//            boolean newPrestadorServico = false;
//
//            PrestadorServico prestadorServico = (PrestadorServico) selectionModel.getSelectedItem();
//            if (prestadorServico == null) {
//                newPrestadorServico = true;
//                prestadorServico = new PrestadorServico();
//                prestadorServico.setAddress(new Address(-1));
//                prestadorServico.setBankAccount(new BankAccount());
//            }
//
//            prestadorServico.setName(namePrestadorServicoTextField.getText());
//            prestadorServico.setService(servicePrestadorServicoTableColumn.getText());
//            prestadorServico.setC(cPrestadorServicoTextField.getText());
//            prestadorServico.setPhoneNumber(phoneNumberPrestadorServicoTextField.getText());
//            prestadorServico.setEmail(emailPrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setStreet(streetPrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setComplement(complementPrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setNeighborhood(neighborhoodPrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setCity(cityPrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setState(statePrestadorServicoTextField.getText());
//            prestadorServico.getAddress().setZipCode(zipCodePrestadorServicoTextField.getText());
//            prestadorServico.getBankAccount().setOwner(namePrestadorServicoTextField.getText());
//            prestadorServico.getBankAccount().setC(cPrestadorServicoTextField.getText());
//            prestadorServico.getBankAccount().setBank(bankAccountPrestadorServicoComboBox.getValue());
//            prestadorServico.getBankAccount().setAgency(agencyAccountPrestadorServicoTextField.getText());
//            prestadorServico.getBankAccount().setNumber(numberAccountPrestadorServicoTextField.getText());
//
//            try {
//                if (newPrestadorServico)
//                    new PrestadoresServicoRepository().insert(prestadorServico);
//                else
//                    new PrestadoresServicoRepository().update(prestadorServico);
//                prestadoresServicoTableView.setItems(FXCollections.observableArrayList(new PrestadoresServicoRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//        deletePrestadorServicoButton.setOnAction(event -> {
//            PrestadorServico prestadorServico = (PrestadorServico) selectionModel.getSelectedItem();
//            if (prestadorServico == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new PrestadoresServicoRepository().remove(prestadorServico);
//                    prestadoresServicoTableView.setItems(FXCollections.observableArrayList(new PrestadoresServicoRepository().getAll()));
//                } catch (SQLException e) {
//                    StageTools.throwable(e, true);
//                }
//            }
//
//            selectionModel.clearSelection();
//            setEditable(false);
//        });
//
//        clearFields();
//        setEditable(false);
//        //</editor-fold>
    }
//
//    //<editor-fold desc="prestadoresServicoTableView">
//    private void clearFields() {
//        namePrestadorServicoTextField.setText("");
//        servicePrestadorServicoTextField.setText("");
//        cPrestadorServicoTextField.setText("");
//        phoneNumberPrestadorServicoTextField.setText("");
//        emailPrestadorServicoTextField.setText("");
//        streetPrestadorServicoTextField.setText("");
//        complementPrestadorServicoTextField.setText("");
//        neighborhoodPrestadorServicoTextField.setText("");
//        cityPrestadorServicoTextField.setText("");
//        statePrestadorServicoTextField.setText("");
//        zipCodePrestadorServicoTextField.setText("");
//        bankAccountPrestadorServicoComboBox.setValue(Bank._null);
//        agencyAccountPrestadorServicoTextField.setText("");
//        numberAccountPrestadorServicoTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        namePrestadorServicoTextField.setEditable(b);
//        servicePrestadorServicoTextField.setEditable(b);
//        cPrestadorServicoTextField.setEditable(b);
//        phoneNumberPrestadorServicoTextField.setEditable(b);
//        emailPrestadorServicoTextField.setEditable(b);
//        streetPrestadorServicoTextField.setEditable(b);
//        complementPrestadorServicoTextField.setEditable(b);
//        neighborhoodPrestadorServicoTextField.setEditable(b);
//        cityPrestadorServicoTextField.setEditable(b);
//        statePrestadorServicoTextField.setEditable(b);
//        zipCodePrestadorServicoTextField.setEditable(b);
//        bankAccountPrestadorServicoComboBox.setDisable(!b);
//        agencyAccountPrestadorServicoTextField.setEditable(b);
//        numberAccountPrestadorServicoTextField.setEditable(b);
//    }
//
//    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
//        addPrestadorServicoButton.setDisable(add);
//        editPrestadorServicoButton.setDisable(edit);
//        savePrestadorServicoButton.setDisable(save);
//        deletePrestadorServicoButton.setDisable(delete);
//    }
//    //</editor-fold>
}
