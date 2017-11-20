package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.StageTools;

/**
 * Created by pedro on 7/13/16.
 * © 2016 Singularity Systems
 */
public class ImoveisCadastroController implements Initializable {
//
//    @FXML
//    private Button saveImovelButton;
//
//    @FXML
//    private TextField livroTextField;
//
//    @FXML
//    private TableColumn<Imovel, String> imovelTableColumn;
//
//    @FXML
//    private TextField nameImovelTextField;
//
//    @FXML
//    private TextArea descriptionImovelTextArea;
//
//    @FXML
//    private TextField streetImovelTextField;
//
//    @FXML
//    private Button editImovelButton;
//
//    @FXML
//    private TableColumn<Address, String> addressImovelTableColumn;
//
//    @FXML
//    private TextField zipCodeImovelTextField;
//
//    @FXML
//    private TextField matriculaTextField;
//
//    @FXML
//    private TextField cityImovelTextField;
//
//    @FXML
//    private TableView<Imovel> imoveisTableView;
//
//    @FXML
//    private TextField cartorioTextField;
//
//    @FXML
//    private TextField folhasTextField;
//
//    @FXML
//    private TextField searchImovelTextField;
//
//    @FXML
//    private Button deleteImovelButton;
//
//    @FXML
//    private TextField stateImovelTextField;
//
//    @FXML
//    private Button addImovelButton;
//
//    @FXML
//    private TextField neighborhoodImovelTextField;
//
//    @FXML
//    private TextField complementImovelTextField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
////<editor-fold desc="Imovel">
//        new AsyncCallable(() -> {
//            imoveisTableView.setItems(FXCollections.observableArrayList(new ImovelRepository().getAll()));
//            return null;
//        }).start();
//
//        imovelTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        addressImovelTableColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
//
//
//        SelectionModel selectionModel = imoveisTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFields();
//            } else {
//                Imovel imovel = (Imovel) newValue;
//                livroTextField.setText(imovel.getBook());
//                nameImovelTextField.setText(imovel.getName());
//                descriptionImovelTextArea.setText(imovel.getDescription());
//                streetImovelTextField.setText(imovel.getAddress().getStreet());
//                zipCodeImovelTextField.setText(imovel.getAddress().getZipCode());
//                matriculaTextField.setText(imovel.getLandRegistry());
//                cityImovelTextField.setText(imovel.getAddress().getCity());
//                cartorioTextField.setText(imovel.getRegistry());
//                folhasTextField.setText(imovel.getSheets());
//                stateImovelTextField.setText(imovel.getAddress().getState());
//                neighborhoodImovelTextField.setText(imovel.getAddress().getNeighborhood());
//                complementImovelTextField.setText(imovel.getAddress().getComplement());
//                setEditable(false);
//            }
//        });
//
//        addImovelButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//        editImovelButton.setOnAction(event -> setEditable(true));
//        saveImovelButton.setOnAction(event -> {
//            boolean newImovel = false;
//
//            Imovel imovel = (Imovel) selectionModel.getSelectedItem();
//            if (imovel == null) {
//                newImovel = true;
//                imovel = new Imovel();
//            }
//
//            imovel.setName(nameImovelTextField.getText());
//            imovel.setBook(livroTextField.getText());
//            imovel.setDescription(descriptionImovelTextArea.getText());
//            imovel.setLandRegistry(matriculaTextField.getText());
//            imovel.setSheets(folhasTextField.getText());
//            imovel.setRegistry(cartorioTextField.getText());
//
//            Address address = new Address(-1);
//            address.setCity(cityImovelTextField.getText());
//            address.setComplement(complementImovelTextField.getText());
//            address.setNeighborhood(neighborhoodImovelTextField.getText());
//            address.setState(stateImovelTextField.getText());
//            address.setStreet(streetImovelTextField.getText());
//            address.setZipCode(zipCodeImovelTextField.getText());
//
//            imovel.setAddress(address);
//
//
//            try {
//                if (newImovel)
//                    new ImovelRepository().insert(imovel);
//                else
//                    new ImovelRepository().update(imovel);
//                imoveisTableView.setItems(FXCollections.observableArrayList(new ImovelRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//
//        deleteImovelButton.setOnAction(event -> {
//            Imovel imovel = (Imovel) selectionModel.getSelectedItem();
//            if (imovel == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new ImovelRepository().remove(imovel);
//                    imoveisTableView.setItems(FXCollections.observableArrayList(new ImovelRepository().getAll()));
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
//        livroTextField.setText("");
//        nameImovelTextField.setText("");
//        descriptionImovelTextArea.setText("");
//        streetImovelTextField.setText("");
//        zipCodeImovelTextField.setText("");
//        matriculaTextField.setText("");
//        cityImovelTextField.setText("");
//        cartorioTextField.setText("");
//        folhasTextField.setText("");
//        searchImovelTextField.setText("");
//        stateImovelTextField.setText("");
//        neighborhoodImovelTextField.setText("");
//        complementImovelTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        livroTextField.setEditable(b);
//        nameImovelTextField.setEditable(b);
//        descriptionImovelTextArea.setEditable(b);
//        streetImovelTextField.setEditable(b);
//        zipCodeImovelTextField.setEditable(b);
//        matriculaTextField.setEditable(b);
//        cityImovelTextField.setEditable(b);
//        cartorioTextField.setEditable(b);
//        folhasTextField.setEditable(b);
//        searchImovelTextField.setEditable(b);
//        stateImovelTextField.setEditable(b);
//        neighborhoodImovelTextField.setEditable(b);
//        complementImovelTextField.setEditable(b);
//    }
}
