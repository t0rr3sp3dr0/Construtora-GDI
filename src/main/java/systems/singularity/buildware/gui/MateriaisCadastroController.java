package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.models.Material;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by lvrma on 08/06/16.
 * © 2016 Singularity Systems
 */
public class MateriaisCadastroController implements Initializable {
//
//    @FXML
//    private TableColumn<Material, String> medidaMaterialTableColumn;
//
//    @FXML
//    private Button saveMaterialButton;
//
//    @FXML
//    private TableColumn<Material, String> marcaMaterialTableColumn;
//
//    @FXML
//    private TextField nomeMateriaisTextField;
//
//    @FXML
//    private TableView<Material> materiaisTableView;
//
//    @FXML
//    private TableColumn<Material, String> materialTableColumn;
//
//    @FXML
//    private Button deleteMaterialButton;
//
//    @FXML
//    private TextField medidaMateriaisTextField;
//
//    @FXML
//    private Button addMaterialButton;
//
//    @FXML
//    private Button editMaterialButton;
//
//    @FXML
//    private TextField searchMaterialTextField;
//
//    @FXML
//    private TextField marcaMateriaisTextField;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="material">
//        new AsyncCallable(() -> {
//            materiaisTableView.setItems(FXCollections.observableArrayList(new MateriaisRepository().getAll()));
//            return null;
//        }).start();
//
//        materialTableColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
//        marcaMaterialTableColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
//        medidaMaterialTableColumn.setCellValueFactory(new PropertyValueFactory<>("medida"));
//
//        SelectionModel selectionModel = materiaisTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFields();
//            } else {
//                Material material = (Material) newValue;
//                nomeMateriaisTextField.setText(material.getNome());
//                medidaMateriaisTextField.setText(material.getMedida());
//                marcaMateriaisTextField.setText(material.getMarca());
//                setEditable(false);
//            }
//        });
//
//        addMaterialButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//        editMaterialButton.setOnAction(event -> setEditable(true));
//        saveMaterialButton.setOnAction(event -> {
//            boolean newMaterial = false;
//
//            Material material = (Material) selectionModel.getSelectedItem();
//            if (material == null) {
//                newMaterial = true;
//                material = new Material();
//            }
//
//            material.setNome(nomeMateriaisTextField.getText());
//            material.setMarca(marcaMateriaisTextField.getText());
//            material.setMedida(medidaMateriaisTextField.getText());
//
//            try {
//                if (newMaterial)
//                    new MateriaisRepository().insert(material);
//                else
//                    new MateriaisRepository().update(material);
//                materiaisTableView.setItems(FXCollections.observableArrayList(new MateriaisRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//
//        deleteMaterialButton.setOnAction(event -> {
//            Material material = (Material) selectionModel.getSelectedItem();
//            if (material == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new MateriaisRepository().remove(material);
//                    materiaisTableView.setItems(FXCollections.observableArrayList(new MateriaisRepository().getAll()));
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
//    //<editor-fold desc="materiaisTableView">
//    private void clearFields() {
//        nomeMateriaisTextField.setText("");
//        marcaMateriaisTextField.setText("");
//        medidaMateriaisTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        nomeMateriaisTextField.setEditable(b);
//        marcaMateriaisTextField.setEditable(b);
//        medidaMateriaisTextField.setEditable(b);
//    }
//
//    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
//        addMaterialButton.setDisable(add);
//        editMaterialButton.setDisable(edit);
//        saveMaterialButton.setDisable(save);
//        deleteMaterialButton.setDisable(delete);
//    }
//    //</editor-fold>
}
