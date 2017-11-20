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
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class ObraCadastroController implements Initializable {
//
//    @FXML
//    private TableColumn<Obra, String> ceiObraTableColumn;
//
//    @FXML
//    private TableColumn<Obra, String> obraTableColumn;
//
//    @FXML
//    private TableView<Obra> obraTableView;
//
//    @FXML
//    private Button addObraButton;
//
//    @FXML
//    private Button editObraButton;
//
//    @FXML
//    private Button saveObraButton;
//
//    @FXML
//    private Button deleteObraButton;
//
//    @FXML
//    private TextField searchObraTextField;
//
//    @FXML
//    private TextField nameObraTextField;
//
//    @FXML
//    private TextField ceiObraTextField;
//
//    @FXML
//    private TextField streetObraTextField;
//
//    @FXML
//    private TextField complementObraTextField;
//
//    @FXML
//    private TextField neighborhoodObraTextField;
//
//    @FXML
//    private TextField cityObraTextField;
//
//    @FXML
//    private TextField stateObraTextField;
//
//    @FXML
//    private TextField zipCodeObraTextField;
//
//    @FXML
//    private ComboBox<Bank> bankAccountObraComboBox;
//
//    @FXML
//    private TextField agencyAccountObraTextField;
//
//    @FXML
//    private TextField numberAccountObraTextField;
//
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="obra">
//        new AsyncCallable(() -> {
//            obraTableView.setItems(FXCollections.observableArrayList(new ObrasRepository().getAll()));
//            return null;
//        }).start();
//
//        ceiObraTableColumn.setCellValueFactory(new PropertyValueFactory<>("cei"));
//        obraTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        SelectionModel selectionModel = obraTableView.getSelectionModel();
//
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFields();
//            } else {
//                Obra obra = (Obra) newValue;
//                nameObraTextField.setText(obra.getNome());
//                ceiObraTextField.setText(obra.getCEI());
//                streetObraTextField.setText(obra.getAddress().getStreet());
//                complementObraTextField.setText(obra.getAddress().getComplement());
//                neighborhoodObraTextField.setText(obra.getAddress().getNeighborhood());
//                cityObraTextField.setText(obra.getAddress().getCity());
//                stateObraTextField.setText(obra.getAddress().getState());
//                zipCodeObraTextField.setText(obra.getAddress().getZipCode());
//                bankAccountObraComboBox.setValue(obra.getBankAccount().getBank());
//                agencyAccountObraTextField.setText(obra.getBankAccount().getAgency());
//                numberAccountObraTextField.setText(obra.getBankAccount().getNumber());
//                setEditable(false);
//            }
//        });
//
//        addObraButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//
//        editObraButton.setOnAction(event -> setEditable(true));
//
//        saveObraButton.setOnAction(event -> {
//            boolean newObra = false;
//
//            Obra obra = (Obra) selectionModel.getSelectedItem();
//            if (obra == null) {
//                newObra = true;
//                obra = new Obra();
//            }
//
//            obra.setNome(nameObraTextField.getText());
//            obra.setCEI(ceiObraTextField.getText());
//
//            BankAccount bankAccount = new BankAccount();
//            bankAccount.setAgency(agencyAccountObraTextField.getText());
//            bankAccount.setBank(bankAccountObraComboBox.getValue());
//            bankAccount.setNumber(numberAccountObraTextField.getText());
//
//            obra.setBankAccount(bankAccount);
//
//            Address address = new Address(-1);
//            address.setStreet(streetObraTextField.getText());
//            address.setComplement(complementObraTextField.getText());
//            address.setNeighborhood(neighborhoodObraTextField.getText());
//            address.setState(stateObraTextField.getText());
//            address.setZipCode(zipCodeObraTextField.getText());
//
//            obra.setAddress(address);
//
//            try {
//                if (newObra)
//                    new ObrasRepository().insert(obra);
//                else
//                    new ObrasRepository().update(obra);
//                obraTableView.setItems(FXCollections.observableArrayList(new ObrasRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//
//        deleteObraButton.setOnAction(event -> {
//            Obra obra = (Obra) selectionModel.getSelectedItem();
//            if (obra == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new ObrasRepository().remove(obra);
//                    obraTableView.setItems(FXCollections.observableArrayList(new ObrasRepository().getAll()));
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
//    private void clearFields() {
//        nameObraTextField.setText("");
//        ceiObraTextField.setText("");
//        streetObraTextField.setText("");
//        complementObraTextField.setText("");
//        neighborhoodObraTextField.setText("");
//        cityObraTextField.setText("");
//        stateObraTextField.setText("");
//        zipCodeObraTextField.setText("");
//        bankAccountObraComboBox.setValue(Bank._null);
//        agencyAccountObraTextField.setText("");
//        numberAccountObraTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        nameObraTextField.setEditable(b);
//        ceiObraTextField.setEditable(b);
//        streetObraTextField.setEditable(b);
//        complementObraTextField.setEditable(b);
//        neighborhoodObraTextField.setEditable(b);
//        cityObraTextField.setEditable(b);
//        stateObraTextField.setEditable(b);
//        zipCodeObraTextField.setEditable(b);
//        bankAccountObraComboBox.setDisable(!b);
//        agencyAccountObraTextField.setEditable(b);
//        numberAccountObraTextField.setEditable(b);
//    }
//
//
}
