package systems.singularity.buildware.gui;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.db.Repositories;
import systems.singularity.buildware.enums.Gender;
import systems.singularity.buildware.enums.MaritalStatus;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.models.Customer;
import systems.singularity.buildware.models.Person;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.ComboBoxAutoComplete;
import systems.singularity.buildware.util.Postmon;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class ClientesCadastroController implements Initializable {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="generoClienteComboBox"
    private ComboBox<Gender> generoClienteComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="profissaoClienteTableColumn"
    private TableColumn<Customer, String> profissaoClienteTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="profissaoClienteTextField"
    private TextField profissaoClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="stateClienteTextField"
    private TextField stateClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="estadoCivilClienteComboBox"
    private ComboBox<MaritalStatus> estadoCivilClienteComboBox; // Value injected by FXMLLoader

    @FXML // fx:id="addClienteButton"
    private Button addClienteButton; // Value injected by FXMLLoader

    @FXML // fx:id="saveClienteButton"
    private Button saveClienteButton; // Value injected by FXMLLoader

    @FXML // fx:id="streetClienteTextField"
    private TextField streetClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="complementClienteTextField"
    private TextField complementClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="clienteTableColumn"
    private TableColumn<Customer, String> clienteTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="birthdateClienteDatePicker"
    private DatePicker birthdateClienteDatePicker; // Value injected by FXMLLoader

    @FXML // fx:id="searchClienteTextField"
    private TextField searchClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="deleteClienteButton"
    private Button deleteClienteButton; // Value injected by FXMLLoader

    @FXML // fx:id="zipCodeClienteTextField"
    private TextField zipCodeClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="editClienteButton"
    private Button editClienteButton; // Value injected by FXMLLoader

    @FXML // fx:id="clientesTableView"
    private TableView<Customer> clientesTableView; // Value injected by FXMLLoader

    @FXML // fx:id="emailClienteTextField"
    private TextField emailClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="emailClienteColumn"
    private TableColumn<Customer, String> emailClienteColumn; // Value injected by FXMLLoader

    @FXML // fx:id="nameClienteTextField"
    private TextField nameClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="cityClienteTextField"
    private TextField cityClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="cpfClienteTableColumn"
    private TableColumn<Customer, String> cpfClienteTableColumn; // Value injected by FXMLLoader

    @FXML // fx:id="cpfClienteTextField"
    private TextField cpfClienteTextField; // Value injected by FXMLLoader

    @FXML // fx:id="neighborhoodClienteTextField"
    private TextField neighborhoodClienteTextField; // Value injected by FXMLLoader

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //<editor-fold desc="cliente">
        refresh(null);

        clienteTableColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPerson().getName()));
        cpfClienteTableColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPerson().getCPF()));
        profissaoClienteTableColumn.setCellValueFactory(new PropertyValueFactory<>("job"));
        emailClienteColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        SelectionModel<Customer> selectionModel = clientesTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null)
                clearFields();
            else {
                nameClienteTextField.setText(newValue.getPerson().getName());
                birthdateClienteDatePicker.setValue(new Date(newValue.getPerson().getBirthdate().getTime()).toLocalDate());
                generoClienteComboBox.getSelectionModel().select(newValue.getPerson().getGender());
                profissaoClienteTextField.setText(newValue.getJob());
                estadoCivilClienteComboBox.getSelectionModel().select(newValue.getMaritalStatus());
                cpfClienteTextField.setText(newValue.getPerson().getCPF());
                emailClienteTextField.setText(newValue.getEmail());
                streetClienteTextField.setText(newValue.getPerson().getAddress().getStreet() + ", " + newValue.getPerson().getAddress().getNumber());
                complementClienteTextField.setText(newValue.getPerson().getAddress().getComplement());
                neighborhoodClienteTextField.setText(newValue.getPerson().getAddress().getNeighborhood());
                cityClienteTextField.setText(newValue.getPerson().getAddress().getCity());
                stateClienteTextField.setText(newValue.getPerson().getAddress().getState());
                zipCodeClienteTextField.setText(newValue.getPerson().getAddress().getZipCode());
                setEditable(false);
            }
        });

        Postmon.addListener(zipCodeClienteTextField, streetClienteTextField, neighborhoodClienteTextField, cityClienteTextField, stateClienteTextField);

        // TODO: Fix buttons' logic (enabled/disabled)
        addClienteButton.setOnAction(event -> {
            selectionModel.clearSelection();
            setEditable(true);
        });
        editClienteButton.setOnAction(event -> setEditable(true));
        saveClienteButton.setOnAction(event -> {
            setEditable(false);

            boolean newCliente = false;

            Customer customer = selectionModel.getSelectedItem();
            if (customer == null) {
                newCliente = true;
                customer = new Customer().person(new Person().address(new Address()));
            }

            customer.getPerson().setName(nameClienteTextField.getText());
            customer.getPerson().setBirthdate(Date.valueOf(birthdateClienteDatePicker.getValue()));
            customer.getPerson().setGender(generoClienteComboBox.getValue());
            customer.setJob(profissaoClienteTextField.getText());
            customer.setMaritalStatus(estadoCivilClienteComboBox.getValue());
            customer.getPerson().setCPF(cpfClienteTextField.getText());
            customer.setEmail(emailClienteTextField.getText());
            customer.getPerson().getAddress().setStreet(streetClienteTextField.getText().split(",")[0].trim());
            customer.getPerson().getAddress().setNumber(streetClienteTextField.getText().contains(",") ? streetClienteTextField.getText().split(",")[1].trim() : "-1");
            customer.getPerson().getAddress().setComplement(complementClienteTextField.getText());
            customer.getPerson().getAddress().setNeighborhood(neighborhoodClienteTextField.getText());
            customer.getPerson().getAddress().setCity(cityClienteTextField.getText());
            customer.getPerson().getAddress().setState(stateClienteTextField.getText());
            customer.getPerson().getAddress().setZipCode(zipCodeClienteTextField.getText());

            try {
                if (newCliente) {
                    customer.getPerson().getAddress().id(Repositories.address.insert(customer.getPerson().getAddress()));
                    customer.getPerson().id(Repositories.person.insert(customer.getPerson()));
                    customer.id(Repositories.customer.insert(customer));
                } else {
                    Repositories.customer.update(customer);
                    Repositories.person.update(customer.getPerson());
                    Repositories.address.update(customer.getPerson().getAddress());
                }
                refresh(customer);
            } catch (SQLException e) {
                StageTools.throwable(e, true);
                setEditable(true);
            }
        });
        deleteClienteButton.setOnAction(event -> {
            Customer customer = selectionModel.getSelectedItem();
            if (customer == null) {
                clearFields();
                setEditable(false);
            } else {
                try {
                    Repositories.customer.remove(customer.getId());
                    Repositories.person.remove(customer.getPerson().getId());
                    Repositories.address.remove(customer.getPerson().getAddress().getId());
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

        //<editor-fold desc="gender">
        generoClienteComboBox.setItems(FXCollections.observableArrayList(Gender.values()));
        new ComboBoxAutoComplete<>(generoClienteComboBox);
        //</editor-fold>

        //<editor-fold desc="maritalStatus">
        estadoCivilClienteComboBox.setItems(FXCollections.observableArrayList(MaritalStatus.values()));
        new ComboBoxAutoComplete<>(estadoCivilClienteComboBox);
        //</editor-fold>
    }

    //<editor-fold desc="clientesTableView">
    public void refresh(Customer select) {
        Platform.runLater(() -> clientesTableView.setDisable(true));

        new AsyncCallable(() -> {
            List<Customer> list = Repositories.customer.getAll().stream().map(customer -> {
                try {
                    return customer.person(Repositories.person.get(customer.getPerson().getId()));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }).map(customer -> {
                try {
                    return customer.person(customer.getPerson().address(Repositories.address.get(customer.getPerson().getAddress().getId())));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }).collect(Collectors.toList());
            ObservableList<Customer> observableList = FXCollections.observableArrayList(list);
            FilteredList<Customer> filteredList = new FilteredList<>(observableList, customer -> true);
            SortedList<Customer> sortedList = new SortedList<>(filteredList);
            sortedList.comparatorProperty().bind(clientesTableView.comparatorProperty());

            Platform.runLater(() -> {
                clientesTableView.setItems(sortedList);
                searchClienteTextField.textProperty().addListener((observable, oldValue, newValue) -> filteredList.setPredicate(customer -> {
                    if (newValue == null || newValue.isEmpty())
                        return true;

                    String lowerCaseFilter = newValue.toLowerCase();
                    String replaceAll = newValue.replaceAll("\\D+", "");

                    // TODO: Amplify search to all parameters
                    if (lowerCaseFilter.length() > 0 && customer.getPerson().getName().toLowerCase().contains(lowerCaseFilter))
                        return true;
                    else if (replaceAll.length() > 0 && customer.getPerson().getCPF().replaceAll("\\D+", "").contains(replaceAll))
                        return true;
                    else if (lowerCaseFilter.length() > 0 && customer.getJob().toLowerCase().contains(lowerCaseFilter))
                        return true;
                    else if (lowerCaseFilter.length() > 0 && customer.getEmail().toLowerCase().contains(lowerCaseFilter))
                        return true;

                    return false;
                }));

                clientesTableView.setDisable(false);
                clientesTableView.getSelectionModel().select(select);
            });

            return null;
        }).start();
    }

    private void clearFields() {
        nameClienteTextField.setText("");
        birthdateClienteDatePicker.setValue(LocalDate.now());
        generoClienteComboBox.getSelectionModel().select(Gender._null);
        profissaoClienteTextField.setText("");
        estadoCivilClienteComboBox.getSelectionModel().select(MaritalStatus._null);
        cpfClienteTextField.setText("");
        emailClienteTextField.setText("");
        streetClienteTextField.setText("");
        complementClienteTextField.setText("");
        neighborhoodClienteTextField.setText("");
        cityClienteTextField.setText("");
        stateClienteTextField.setText("");
        zipCodeClienteTextField.setText("");
    }

    private void setEditable(boolean b) {
        nameClienteTextField.setEditable(b);
        birthdateClienteDatePicker.setDisable(!b);
        generoClienteComboBox.setDisable(!b);
        profissaoClienteTextField.setEditable(b);
        estadoCivilClienteComboBox.setDisable(!b);
        cpfClienteTextField.setEditable(b);
        emailClienteTextField.setEditable(b);
        streetClienteTextField.setEditable(b);
        complementClienteTextField.setEditable(b);
        neighborhoodClienteTextField.setEditable(b);
        cityClienteTextField.setEditable(b);
        stateClienteTextField.setEditable(b);
        zipCodeClienteTextField.setEditable(b);
    }

    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
        addClienteButton.setDisable(add);
        editClienteButton.setDisable(edit);
        saveClienteButton.setDisable(save);
        deleteClienteButton.setDisable(delete);
    }
    //</editor-fold>
}
