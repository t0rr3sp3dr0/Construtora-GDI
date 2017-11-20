package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.enums.Bank;
import systems.singularity.buildware.models.*;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.Postmon;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class ImobiliariasCadastroController implements Initializable {
//    @FXML
//    private TextField emailImobiliariaTextField;
//    @FXML
//    private ComboBox<Bank> bankAccountImobiliariaComboBox;
//    @FXML
//    private TextField neighborhoodImobiliariaTextField;
//    @FXML
//    private TextField emailContatosImobiliariaTextField;
//    @FXML
//    private Button editImobiliariaButton;
//    @FXML
//    private Button addImobiliariaButton;
//    @FXML
//    private TableColumn<Contact, String> contatosImobiliariaTableColumn;
//    @FXML
//    private TextField phoneNumberContatosImobiliariaTextField;
//    @FXML
//    private TextField complementImobiliariaTextField;
//    @FXML
//    private TextField stateImobiliariaTextField;
//    @FXML
//    private TableView<Imobiliaria> imobiliariasTableView;
//    @FXML
//    private TextField phoneNumberImobiliariaTextField;
//    @FXML
//    private TableColumn<Contact, String> emailContatosImobiliariaTableColumn;
//    @FXML
//    private TextField nameContatosImobiliariaTextField;
//    @FXML
//    private TextField creciImobiliariaTextField;
//    @FXML
//    private TextField cityImobiliariaTextField;
//    @FXML
//    private TextField agencyAccountImobiliariaTextField;
//    @FXML
//    private TableColumn<Contact, String> phoneNumberContatosImobiliariaTableColumn;
//    @FXML
//    private Button editContatosImobiliariaButton;
//    @FXML
//    private Button deleteContatosImobiliariaButton;
//    @FXML
//    private TableColumn<Imobiliaria, String> emailImobiliariaTableColumn;
//    @FXML
//    private TableView<Contact> contatosImobiliariaTableView;
//    @FXML
//    private TextField nameImobiliariaTextField;
//    @FXML
//    private Button addContatosImobiliariaButton;
//    @FXML
//    private TextField zipCodeImobiliariaTextField;
//    @FXML
//    private TableColumn<Imobiliaria, String> creciImobiliariaTableColumn;
//    @FXML
//    private TableColumn<Imobiliaria, String> phoneNumberImobiliariaTableColumn;
//    @FXML
//    private Button saveImobiliariaButton;
//    @FXML
//    private TextField numberAccountImobiliariaTextField;
//    @FXML
//    private TextField cnpjImobiliariaTextField;
//    @FXML
//    private TextField searchImobiliariaTextField;
//    @FXML
//    private Button deleteImobiliariaButton;
//    @FXML
//    private Button saveContatosImobiliariaButton;
//    @FXML
//    private TableColumn<Imobiliaria, String> imobiliariaTableColumn;
//    @FXML
//    private TextField streetImobiliariaTextField;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="imobiliaria">
//        new AsyncCallable(() -> {
//            imobiliariasTableView.setItems(FXCollections.observableArrayList(new ImobiliariasRepository().getAll()));
//            return null;
//        }).start();
//
//        imobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        creciImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("cRECI"));
//        phoneNumberImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        emailImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        SelectionModel selectionModel = imobiliariasTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFields();
//
//                contatosImobiliariaTableView.setItems(FXCollections.observableArrayList());
//                clearFieldsContatos();
//                editContatosImobiliariaButton.setDisable(true);
//                contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(true);
//            } else {
//                Imobiliaria imobiliaria = (Imobiliaria) newValue;
//                Address imobiliariaAddress = imobiliaria.getAddress();
//                BankAccount imobiliariaAccount = imobiliaria.getBankAccount();
//
//                nameImobiliariaTextField.setText(imobiliaria.getName());
//                creciImobiliariaTextField.setText(imobiliaria.getCRECI());
//                cnpjImobiliariaTextField.setText(imobiliaria.getCNPJ());
//                phoneNumberImobiliariaTextField.setText(imobiliaria.getPhoneNumber());
//                emailImobiliariaTextField.setText(imobiliaria.getEmail());
//                streetImobiliariaTextField.setText(imobiliariaAddress.getStreet());
//                complementImobiliariaTextField.setText(imobiliariaAddress.getComplement());
//                neighborhoodImobiliariaTextField.setText(imobiliariaAddress.getNeighborhood());
//                cityImobiliariaTextField.setText(imobiliariaAddress.getCity());
//                stateImobiliariaTextField.setText(imobiliariaAddress.getState());
//                zipCodeImobiliariaTextField.setText(imobiliariaAddress.getZipCode());
//                bankAccountImobiliariaComboBox.setValue(imobiliariaAccount.getBank());
//                agencyAccountImobiliariaTextField.setText(imobiliariaAccount.getAgency());
//                numberAccountImobiliariaTextField.setText(imobiliariaAccount.getNumber());
//
//                contatosImobiliariaTableView.setItems(FXCollections.observableArrayList(imobiliaria.getContacts()));
//                setEditableContatos(false);
//                contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(false);
//            }
//        });
//
//        Postmon.addListener(zipCodeImobiliariaTextField, streetImobiliariaTextField, neighborhoodImobiliariaTextField, cityImobiliariaTextField, stateImobiliariaTextField, null);
//
//        addImobiliariaButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//
//            setEditableContatos(false);
//            contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(true);
//        });
//        editImobiliariaButton.setOnAction(event -> {
//            setEditable(true);
//
//            setEditableContatos(false);
//            contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(true);
//        });
//        saveImobiliariaButton.setOnAction(event -> {
//            boolean newImobiliaria = false;
//
//            Imobiliaria imobiliaria = (Imobiliaria) selectionModel.getSelectedItem();
//            if (imobiliaria == null) {
//                newImobiliaria = true;
//                imobiliaria = new Imobiliaria();
//                imobiliaria.setAddress(new Address(-1));
//                imobiliaria.setBankAccount(new BankAccount());
//            }
//
//            imobiliaria.setName(nameImobiliariaTextField.getText());
//            imobiliaria.setCRECI(creciImobiliariaTextField.getText());
//            imobiliaria.setCNPJ(cnpjImobiliariaTextField.getText());
//            imobiliaria.setPhoneNumber(phoneNumberImobiliariaTextField.getText());
//            imobiliaria.setEmail(emailImobiliariaTextField.getText());
//            imobiliaria.getAddress().setStreet(streetImobiliariaTextField.getText());
//            imobiliaria.getAddress().setComplement(complementImobiliariaTextField.getText());
//            imobiliaria.getAddress().setNeighborhood(neighborhoodImobiliariaTextField.getText());
//            imobiliaria.getAddress().setCity(cityImobiliariaTextField.getText());
//            imobiliaria.getAddress().setState(stateImobiliariaTextField.getText());
//            imobiliaria.getAddress().setZipCode(zipCodeImobiliariaTextField.getText());
//            imobiliaria.getBankAccount().setOwner(nameImobiliariaTextField.getText());
//            imobiliaria.getBankAccount().setC(cnpjImobiliariaTextField.getText());
//            imobiliaria.getBankAccount().setBank(bankAccountImobiliariaComboBox.getValue());
//            imobiliaria.getBankAccount().setAgency(agencyAccountImobiliariaTextField.getText());
//            imobiliaria.getBankAccount().setNumber(numberAccountImobiliariaTextField.getText());
//            imobiliaria.setContacts(new ArrayList<>(contatosImobiliariaTableView.getItems()));
//
//            try {
//                if (newImobiliaria)
//                    new ImobiliariasRepository().insert(imobiliaria);
//                else
//                    new ImobiliariasRepository().update(imobiliaria);
//                imobiliariasTableView.setItems(FXCollections.observableArrayList(new ImobiliariasRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//
//            setEditableContatos(false);
//            contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(false);
//        });
//        deleteImobiliariaButton.setOnAction(event -> {
//            Imobiliaria imobiliaria = (Imobiliaria) selectionModel.getSelectedItem();
//            if (imobiliaria == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new ImobiliariasRepository().remove(imobiliaria);
//                    imobiliariasTableView.setItems(FXCollections.observableArrayList(new ImobiliariasRepository().getAll()));
//                } catch (SQLException e) {
//                    StageTools.throwable(e, true);
//                }
//            }
//
//            selectionModel.clearSelection();
//            setEditable(false);
//
//            setEditableContatos(false);
//            contatosImobiliariaTableView.getSelectionModel().setCellSelectionEnabled(false);
//        });
//
//        clearFields();
//        setEditable(false);
//        //</editor-fold>
//
//        //<editor-fold desc="contatosImobiliaria">
//        contatosImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        phoneNumberContatosImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        emailContatosImobiliariaTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        SelectionModel contatosSelectionModel = contatosImobiliariaTableView.getSelectionModel();
//        contatosSelectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFieldsContatos();
//                editContatosImobiliariaButton.setDisable(true);
//            } else {
//                Contact contact = (Contact) newValue;
//                nameContatosImobiliariaTextField.setText(contact.getName());
//                phoneNumberContatosImobiliariaTextField.setText(contact.getPhoneNumber());
//                emailContatosImobiliariaTextField.setText(contact.getEmail());
//
//                setEditableContatos(false);
//            }
//        });
//
//        addContatosImobiliariaButton.setOnAction(event -> {
//            contatosSelectionModel.clearSelection();
//            clearFieldsContatos();
//            setEditableContatos(true);
//        });
//        editContatosImobiliariaButton.setOnAction(event -> setEditableContatos(true));
//        saveContatosImobiliariaButton.setOnAction(event -> {
//            boolean newContact = false;
//
//            Contact contact = (Contact) contatosSelectionModel.getSelectedItem();
//            if (contact == null) {
//                newContact = true;
//                contact = new Contact();
//            }
//
//            contact.setName(nameContatosImobiliariaTextField.getText());
//            contact.setPhoneNumber(phoneNumberContatosImobiliariaTextField.getText());
//            contact.setEmail(emailContatosImobiliariaTextField.getText());
//
//            if (newContact)
//                contatosImobiliariaTableView.getItems().add(contact);
//
//            setEditableContatos(false);
//
//            StageTools.reloadTableView(contatosImobiliariaTableView);
//        });
//        deleteContatosImobiliariaButton.setOnAction(event -> {
//            Contact contact = (Contact) contatosSelectionModel.getSelectedItem();
//            if (contact == null) {
//                clearFieldsContatos();
//                setEditableContatos(false);
//            } else
//                contatosImobiliariaTableView.getItems().remove(contact);
//
//            setEditableContatos(false);
//        });
//
//        clearFieldsContatos();
//        setEditableContatos(false);
//        //</editor-fold>
    }
//
//    //<editor-fold desc="imobiliariasTableView">
//    private void clearFields() {
//        nameImobiliariaTextField.setText("");
//        creciImobiliariaTextField.setText("");
//        cnpjImobiliariaTextField.setText("");
//        phoneNumberImobiliariaTextField.setText("");
//        emailImobiliariaTextField.setText("");
//        streetImobiliariaTextField.setText("");
//        complementImobiliariaTextField.setText("");
//        neighborhoodImobiliariaTextField.setText("");
//        cityImobiliariaTextField.setText("");
//        stateImobiliariaTextField.setText("");
//        zipCodeImobiliariaTextField.setText("");
//        bankAccountImobiliariaComboBox.setValue(Bank._null);
//        agencyAccountImobiliariaTextField.setText("");
//        numberAccountImobiliariaTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        nameImobiliariaTextField.setEditable(b);
//        creciImobiliariaTextField.setEditable(b);
//        cnpjImobiliariaTextField.setEditable(b);
//        phoneNumberImobiliariaTextField.setEditable(b);
//        emailImobiliariaTextField.setEditable(b);
//        streetImobiliariaTextField.setEditable(b);
//        complementImobiliariaTextField.setEditable(b);
//        neighborhoodImobiliariaTextField.setEditable(b);
//        cityImobiliariaTextField.setEditable(b);
//        stateImobiliariaTextField.setEditable(b);
//        zipCodeImobiliariaTextField.setEditable(b);
//        bankAccountImobiliariaComboBox.setDisable(!b);
//        agencyAccountImobiliariaTextField.setEditable(b);
//        numberAccountImobiliariaTextField.setEditable(b);
//    }
//
//    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
//        addImobiliariaButton.setDisable(add);
//        editImobiliariaButton.setDisable(edit);
//        saveImobiliariaButton.setDisable(save);
//        deleteImobiliariaButton.setDisable(delete);
//    }
//    //</editor-fold>
//
//    //<editor-fold desc="contatosImobiliariaTableView">
//    private void clearFieldsContatos() {
//        nameContatosImobiliariaTextField.setText("");
//        phoneNumberContatosImobiliariaTextField.setText("");
//        emailContatosImobiliariaTextField.setText("");
//    }
//
//    private void setEditableContatos(boolean b) {
//        nameContatosImobiliariaTextField.setEditable(b);
//        phoneNumberContatosImobiliariaTextField.setEditable(b);
//        emailContatosImobiliariaTextField.setEditable(b);
//    }
//
//    private void disableButtonsContatos(boolean add, boolean edit, boolean save, boolean delete) {
//        addContatosImobiliariaButton.setDisable(add);
//        editContatosImobiliariaButton.setDisable(edit);
//        saveContatosImobiliariaButton.setDisable(save);
//        deleteContatosImobiliariaButton.setDisable(delete);
//    }
//    //</editor-fold>
}
