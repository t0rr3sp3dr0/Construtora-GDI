package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.enums.Bank;
import systems.singularity.buildware.models.*;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.ComboBoxAutoComplete;
import systems.singularity.buildware.util.Postmon;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class CorretoresCadastroController implements Initializable {
//    @FXML
//    private Button saveCorretorButton;
//    @FXML
//    private TableColumn<Corretor, String> phoneNumberCorretorTableColumn;
//    @FXML
//    private DatePicker birthdateCorretorDatePicker;
//    @FXML
//    private TextField searchCorretorTextField;
//    @FXML
//    private Button addCorretorButton;
//    @FXML
//    private TextField complementCorretorTextField;
//    @FXML
//    private TableView<Corretor> corretoresTableView;
//    @FXML
//    private TableColumn<Corretor, String> cpfCorretorTableColumn;
//    @FXML
//    private Button editCorretorButton;
//    @FXML
//    private TextField neighborhoodCorretorTextField;
//    @FXML
//    private TableColumn<Corretor, String> emailCorretorTableColumn;
//    @FXML
//    private TextField emailCorretorTextField;
//    @FXML
//    private TextField birthplaceCorretorTextField;
//    @FXML
//    private TextField cityCorretorTextField;
//    @FXML
//    private TableColumn<Corretor, String> corretorTableColumn;
//    @FXML
//    private TextField cpfCorretorTextField;
//    @FXML
//    private ComboBox<Bank> bankAccountCorretorComboBox;
//    @FXML
//    private TextField nameCorretorTextField;
//    @FXML
//    private TextField phoneNumberCorretorTextField;
//    @FXML
//    private TextField agencyAccountCorretorTextField;
//    @FXML
//    private ComboBox<Imobiliaria> imobiliariaCorretorComboBox;
//    @FXML
//    private TextField streetCorretorTextField;
//    @FXML
//    private TextField creciCorretorTextField;
//    @FXML
//    private TextField rgCorretorTextField;
//    @FXML
//    private TextField stateCorretorTextField;
//    @FXML
//    private TextField zipCodeCorretorTextField;
//    @FXML
//    private TextField numberAccountCorretorTextField;
//    @FXML
//    private Button deleteCorretorButton;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="corretor">
//        new AsyncCallable(() -> {
//            corretoresTableView.setItems(FXCollections.observableArrayList(new CorretoresRepository().getAll()));
//            return null;
//        }).start();
//
//        corretorTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        cpfCorretorTableColumn.setCellValueFactory(new PropertyValueFactory<>("cPF"));
//        phoneNumberCorretorTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        emailCorretorTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        SelectionModel selectionModel = corretoresTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null)
//                clearFields();
//            else {
//                Corretor corretor = (Corretor) newValue;
//                Address corretorAddress = corretor.getAddress();
//                BankAccount corretorAccount = corretor.getBankAccount();
//
//                nameCorretorTextField.setText(corretor.getName());
//                imobiliariaCorretorComboBox.setValue(corretor.getImobiliaria());
//                creciCorretorTextField.setText(corretor.getCRECI());
//                birthplaceCorretorTextField.setText(corretor.getBirthplace());
//                if (corretor.getBirthdate() != null)
//                    birthdateCorretorDatePicker.setValue(corretor.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                cpfCorretorTextField.setText(corretor.getCPF());
//                rgCorretorTextField.setText(corretor.getRG());
//                phoneNumberCorretorTextField.setText(corretor.getPhoneNumber());
//                emailCorretorTextField.setText(corretor.getEmail());
//                streetCorretorTextField.setText(corretorAddress.getStreet());
//                complementCorretorTextField.setText(corretorAddress.getComplement());
//                neighborhoodCorretorTextField.setText(corretorAddress.getNeighborhood());
//                cityCorretorTextField.setText(corretorAddress.getCity());
//                stateCorretorTextField.setText(corretorAddress.getState());
//                zipCodeCorretorTextField.setText(corretorAddress.getZipCode());
//                bankAccountCorretorComboBox.setValue(corretorAccount.getBank());
//                agencyAccountCorretorTextField.setText(corretorAccount.getAgency());
//                numberAccountCorretorTextField.setText(corretorAccount.getNumber());
//            }
//        });
//
//        Postmon.addListener(zipCodeCorretorTextField, streetCorretorTextField, neighborhoodCorretorTextField, cityCorretorTextField, stateCorretorTextField, null);
//
//        addCorretorButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//        editCorretorButton.setOnAction(event -> setEditable(true));
//        saveCorretorButton.setOnAction(event -> {
//            boolean newCorretor = false;
//
//            Corretor corretor = (Corretor) selectionModel.getSelectedItem();
//            if (corretor == null) {
//                newCorretor = true;
//                corretor = new Corretor();
//                corretor.setAddress(new Address(-1));
//                corretor.setBankAccount(new BankAccount());
//            }
//
//            corretor.setName(nameCorretorTextField.getText());
//            corretor.setImobiliaria(imobiliariaCorretorComboBox.getValue());
//            corretor.setCRECI(creciCorretorTextField.getText());
//            corretor.setBirthplace(birthplaceCorretorTextField.getText());
//            if (birthdateCorretorDatePicker.getValue() != null)
//                corretor.setBirthdate(Date.from(birthdateCorretorDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            corretor.setCPF(cpfCorretorTextField.getText());
//            corretor.setRG(rgCorretorTextField.getText());
//            corretor.setPhoneNumber(phoneNumberCorretorTextField.getText());
//            corretor.setEmail(emailCorretorTextField.getText());
//            corretor.getAddress().setStreet(streetCorretorTextField.getText());
//            corretor.getAddress().setComplement(complementCorretorTextField.getText());
//            corretor.getAddress().setNeighborhood(neighborhoodCorretorTextField.getText());
//            corretor.getAddress().setCity(cityCorretorTextField.getText());
//            corretor.getAddress().setState(stateCorretorTextField.getText());
//            corretor.getAddress().setZipCode(zipCodeCorretorTextField.getText());
//            corretor.getBankAccount().setOwner(nameCorretorTextField.getText());
//            corretor.getBankAccount().setC(cpfCorretorTextField.getText());
//            corretor.getBankAccount().setBank(bankAccountCorretorComboBox.getValue());
//            corretor.getBankAccount().setAgency(agencyAccountCorretorTextField.getText());
//            corretor.getBankAccount().setNumber(numberAccountCorretorTextField.getText());
//
//            try {
//                if (newCorretor)
//                    new CorretoresRepository().insert(corretor);
//                else
//                    new CorretoresRepository().update(corretor);
//                corretoresTableView.setItems(FXCollections.observableArrayList(new CorretoresRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//        deleteCorretorButton.setOnAction(event -> {
//            Corretor corretor = (Corretor) selectionModel.getSelectedItem();
//            if (corretor == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new CorretoresRepository().remove(corretor);
//                    corretoresTableView.setItems(FXCollections.observableArrayList(new CorretoresRepository().getAll()));
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
//
//        //<editor-fold desc="maritalStatusCorretor">
//        imobiliariaCorretorComboBox.setItems(FXCollections.observableArrayList()); // TODO: Imobiliaria._enum()
//        new ComboBoxAutoComplete<>(imobiliariaCorretorComboBox);
//        //</editor-fold>
    }
//
//    //<editor-fold desc="corretoresTableView">
//    private void clearFields() {
//        nameCorretorTextField.setText("");
//        imobiliariaCorretorComboBox.setValue(null); // TODO: Imobiliaria._enum()._null
//        creciCorretorTextField.setText("");
//        birthplaceCorretorTextField.setText("");
//        birthdateCorretorDatePicker.setValue(null);
//        cpfCorretorTextField.setText("");
//        rgCorretorTextField.setText("");
//        phoneNumberCorretorTextField.setText("");
//        emailCorretorTextField.setText("");
//        streetCorretorTextField.setText("");
//        complementCorretorTextField.setText("");
//        neighborhoodCorretorTextField.setText("");
//        cityCorretorTextField.setText("");
//        stateCorretorTextField.setText("");
//        zipCodeCorretorTextField.setText("");
//        bankAccountCorretorComboBox.setValue(Bank._null);
//        agencyAccountCorretorTextField.setText("");
//        numberAccountCorretorTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        nameCorretorTextField.setEditable(b);
//        imobiliariaCorretorComboBox.setDisable(!b);
//        creciCorretorTextField.setEditable(b);
//        birthplaceCorretorTextField.setEditable(b);
//        birthdateCorretorDatePicker.setDisable(!b);
//        cpfCorretorTextField.setEditable(b);
//        rgCorretorTextField.setEditable(b);
//        phoneNumberCorretorTextField.setEditable(b);
//        emailCorretorTextField.setEditable(b);
//        streetCorretorTextField.setEditable(b);
//        complementCorretorTextField.setEditable(b);
//        neighborhoodCorretorTextField.setEditable(b);
//        cityCorretorTextField.setEditable(b);
//        stateCorretorTextField.setEditable(b);
//        zipCodeCorretorTextField.setEditable(b);
//        bankAccountCorretorComboBox.setDisable(!b);
//        agencyAccountCorretorTextField.setEditable(b);
//        numberAccountCorretorTextField.setEditable(b);
//    }
//
//    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
//        addCorretorButton.setDisable(add);
//        editCorretorButton.setDisable(edit);
//        saveCorretorButton.setDisable(save);
//        deleteCorretorButton.setDisable(delete);
//    }
//    //</editor-fold>
}
