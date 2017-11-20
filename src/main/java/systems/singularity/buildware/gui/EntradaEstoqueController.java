package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import systems.singularity.buildware.models.*;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.ComboBoxAutoComplete;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by caesa on 30/07/2016.
 */
public class EntradaEstoqueController implements Initializable {
//
//    @FXML
//    private TableColumn<Compra, String> precoCompraTableColumn;
//
//    @FXML
//    private TextField acrescimoComprasTextField;
//
//    @FXML
//    private TableView<Compra> comprasTableView;
//
//    @FXML
//    private Button editCompraButton;
//
//    @FXML
//    private TextField searchCompraTextField;
//
//    @FXML
//    private DatePicker dataComprasDatePicker;
//
//    @FXML
//    private ComboBox<Material> materialComprasComboBox;
//
//    @FXML
//    private ComboBox<Obra> destinoComprasComboBox;
//
//    @FXML
//    private TableColumn<Material, String> materialCompraTableColumn;
//
//    @FXML
//    private TextField precoComprasTextField;
//
//    @FXML
//    private Button addCompraButton;
//
//    @FXML
//    private TableColumn<Compra, String> quantidadeCompraTableColumn;
//
//    @FXML
//    private Button deleteComprasButton;
//
//    @FXML
//    private Button saveCompraButton;
//
//    @FXML
//    private TextField quantidadeComprasTextField;
//
//    @FXML
//    private TextField descontoComprasTextField;
//
//    @FXML
//    private ComboBox<Fornecedor> fornecedorComprasComboBox;
//
//    @FXML
//    private TableColumn<Compra, String> dataCompraTableColumn;
//
//    @FXML
//    private TextField totalComprasTextField;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//
////<editor-fold desc="compra">
//        new AsyncCallable(() -> {
//            comprasTableView.setItems(FXCollections.observableArrayList(new ComprasRepository().getAll()));
//            return null;
//        }).start();
//
//        precoCompraTableColumn.setCellValueFactory(new PropertyValueFactory<>("valor"));
//        materialCompraTableColumn.setCellValueFactory(new PropertyValueFactory<>("nome"));
//        quantidadeCompraTableColumn.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
//        dataCompraTableColumn.setCellValueFactory(new PropertyValueFactory<>("dataCompra"));
//
//        SelectionModel selectionModel = comprasTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null) {
//                clearFields();
//
//            } else {
//                Compra compra = (Compra) newValue;
//                Material compraMaterial = compra.getMaterial();
//                Fornecedor compraFornecedor = compra.getFornecedor();
//                Obra compraDestino = compra.getDestino();
//
//                materialComprasComboBox.setValue(compraMaterial);
//                destinoComprasComboBox.setValue(compraDestino);
//                fornecedorComprasComboBox.setValue(compraFornecedor);
//                quantidadeComprasTextField.setText(String.valueOf(compra.getQuantidade()));
//                precoComprasTextField.setText(String.valueOf(compra.getValor()));
//                acrescimoComprasTextField.setText(String.valueOf(compra.getAcrescimo()));
//                descontoComprasTextField.setText(String.valueOf(compra.getDesconto()));
//                dataComprasDatePicker.setValue(compra.getDataCompra().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                totalComprasTextField.setText(String.valueOf(compra.getPrecoFinal()));
//
//            }
//        });
//
//        addCompraButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//         });
//        editCompraButton.setOnAction(event -> {
//            setEditable(true);
//        });
//        saveCompraButton.setOnAction(event -> {
//            boolean newCompra = false;
//
//            Compra compra = (Compra) selectionModel.getSelectedItem();
//            if (compra == null) {
//                newCompra = true;
//                compra = new Compra();
//                compra.setDestino(new Obra());
//                compra.setFornecedor(new Fornecedor());
//                compra.setMaterial(new Material());
//            }
//
//            compra.setMaterial(materialComprasComboBox.getValue());
//            compra.setFornecedor(fornecedorComprasComboBox.getValue());
//            compra.setDestino(destinoComprasComboBox.getValue());
//            compra.setAcrescimo(Double.parseDouble(acrescimoComprasTextField.getText()));
//            compra.setDesconto(Double.parseDouble(descontoComprasTextField.getText()));
//            compra.setPrecoFinal(Double.parseDouble(totalComprasTextField.getText()));
//            compra.setQuantidade(Integer.parseInt(quantidadeComprasTextField.getText()));
//            compra.setValor(Double.parseDouble(precoComprasTextField.getText()));
//            compra.setDataCompra(Date.from(dataComprasDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//
//
//            try {
//                if (newCompra)
//                    new ComprasRepository().insert(compra);
//                else
//                    new ComprasRepository().update(compra);
//                comprasTableView.setItems(FXCollections.observableArrayList(new ComprasRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//
//        });
//        deleteComprasButton.setOnAction(event -> {
//            Compra compra = (Compra) selectionModel.getSelectedItem();
//            if (compra == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new ComprasRepository().remove(compra);
//                    comprasTableView.setItems(FXCollections.observableArrayList(new ComprasRepository().getAll()));
//                } catch (SQLException e) {
//                    StageTools.throwable(e, true);
//                }
//            }
//
//            selectionModel.clearSelection();
//            setEditable(false);
//
//        });
//
//        clearFields();
//        setEditable(false);
//        //</editor-fold>
//
//        //<editor-fold desc="material">
//        materialComprasComboBox.setItems(FXCollections.observableArrayList()); // TODO: material
//        new ComboBoxAutoComplete<>(materialComprasComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="fornecedor">
//        fornecedorComprasComboBox.setItems(FXCollections.observableArrayList()); // TODO: fornecedor
//        new ComboBoxAutoComplete<>(fornecedorComprasComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="material">
//        destinoComprasComboBox.setItems(FXCollections.observableArrayList()); // TODO: obra
//        new ComboBoxAutoComplete<>(destinoComprasComboBox);
//        //</editor-fold>
//
    }
//
//    private void clearFields() {
//        acrescimoComprasTextField.setText("");
//        quantidadeComprasTextField.setText("");
//        descontoComprasTextField.setText("");
//        precoComprasTextField.setText("");
//        searchCompraTextField.setText("");
//        totalComprasTextField.setText("");
//        materialComprasComboBox.setValue(null);
//        destinoComprasComboBox.setValue(null);
//        dataComprasDatePicker.setValue(null);
//        fornecedorComprasComboBox.setValue(null);
//
//    }
//
//    private void setEditable(boolean b) {
//        acrescimoComprasTextField.setEditable(b);
//        quantidadeComprasTextField.setEditable(b);
//        descontoComprasTextField.setEditable(b);
//        precoComprasTextField.setEditable(b);
//        searchCompraTextField.setEditable(b);
//        totalComprasTextField.setEditable(b);
//        materialComprasComboBox.setDisable(!b);
//        destinoComprasComboBox.setDisable(!b);
//        dataComprasDatePicker.setDisable(!b);
//        fornecedorComprasComboBox.setDisable(!b);
//    }
}
