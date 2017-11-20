package systems.singularity.buildware.gui;

import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import systems.singularity.buildware.enums.*;
import systems.singularity.buildware.models.Address;
import systems.singularity.buildware.models.BankAccount;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.ComboBoxAutoComplete;
import systems.singularity.buildware.util.Postmon;
import systems.singularity.buildware.util.StageTools;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by pedro on 4/25/16.
 * © 2016 Singularity Systems
 */
public class TrabalhadoresCadastroController implements Initializable {
//    @FXML
//    private Button addTrabalhadorButton;
//    @FXML
//    private TextField ctpsTrabalhadorTextField;
//    @FXML
//    private ComboBox<EducationalLevel> educationalLevelTrabalhadorComboBox;
//    @FXML
//    private Button editTrabalhadorButton;
//    @FXML
//    private Button editDependentesTrabalhadorButton;
//    @FXML
//    private TextField stateTrabalhadorTextField;
//    @FXML
//    private DatePicker hiringDateTrabalhadorDatePicker;
//    @FXML
//    private ComboBox<CBO> cboTrabalhadorComboBox;
//    @FXML
//    private DatePicker birthdateDependentesTrabalhadorDatePicker;
//    @FXML
//    private ComboBox<Relationship> relationshipDependentesTrabalhadorComboBox;  // TODO: Create relationships enum
//    @FXML
//    private TextField searchTrabalhadorTextField;
//    @FXML
//    private TextField neighborhoodTrabalhadorTextField;
//    @FXML
//    private Button saveDependentesTrabalhadorButton;
//    @FXML
//    private TableColumn<Trabalhador, String> emailTrabalhadorTableColumn;
//    @FXML
//    private TextField motherNameTrabalhadorTextField;
//    @FXML
//    private TextField fatherNameTrabalhadorTextField;
//    @FXML
//    private TextField zipCodeTrabalhadorTextField;
//    @FXML
//    private TableColumn<Trabalhador, String> cpfTrabalhadorTableColumn;
//    @FXML
//    private TextField nisTrabalhadorTextField;
//    @FXML
//    private TextField nicknameTrabalhadorTextField;
//    @FXML
//    private ComboBox<Gender> genderTrabalhadorComboBox;
//    @FXML
//    private DatePicker terminationDateTrabalhadorDatePicker;
//    @FXML
//    private TextField emailTrabalhadorTextField;
//    @FXML
//    private TextField salaryTrabalhadorTextField;
//    @FXML
//    private TextField streetTrabalhadorTextField;
//    @FXML
//    private ComboBox<Race> raceTrabalhadorComboBox;
//    @FXML
//    private DatePicker birthdateTrabalhadorDatePicker;
//    @FXML
//    private Button deleteTrabalhadorButton;
//    @FXML
//    private ComboBox<MaritalStatus> maritalStatusTrabalhadorComboBox;
//    @FXML
//    private TableColumn<?, Date> birthdateDependentesTrabalhadorTableColumn;
//    @FXML
//    private ComboBox<Situation> situationTrabalhadorComboBox;  // TODO: Create stuations enum
//    @FXML
//    private TableColumn<?, String> dependentesTrabalhadorTableColumn;
//    @FXML
//    private TextField phoneNumberTrabalhadorTextField;
//    @FXML
//    private Button addDependentesTrabalhadorButton;
//    @FXML
//    private ComboBox<Bank> bankAccountTrabalhadorComboBox;
//    @FXML
//    private TextField numberAccountTrabalhadorTextField;
//    @FXML
//    private TextField nameDependentesTrabalhadorTextField;
//    @FXML
//    private Button saveTrabalhadorButton;
//    @FXML
//    private TextField birthplaceTrabalhadorTextField;
//    @FXML
//    private Button deleteDependentesTrabalhadorButton;
//    @FXML
//    private TextField nameTrabalhadorTextField;
//    @FXML
//    private ImageView trabalhadorImageView;
//    @FXML
//    private TableView<Trabalhador> trabalhadoresTableView;
//    @FXML
//    private TableColumn<Trabalhador, String> trabalhadorTableColumn;
//    @FXML
//    private TableColumn<?, Relationship> relationshipDependentesTrabalhadorTableColumn;
//    @FXML
//    private TextField agencyAccountTrabalhadorTextField;
//    @FXML
//    private TextField rgTrabalhadorTextField;
//    @FXML
//    private TextField cpfTrabalhadorTextField;
//    @FXML
//    private TableView<?> dependentesTrabalhadorTableView; // TODO: Create dependents class (extends person)
//    @FXML
//    private TableColumn<Trabalhador, String> phoneNumberTrabalhadorTableColumn;
//    @FXML
//    private TextField complementTrabalhadorTextField;
//    @FXML
//    private TextField cityTrabalhadorTextField;
//
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        //<editor-fold desc="trabalhador">
//        new AsyncCallable(() -> {
//            trabalhadoresTableView.setItems(FXCollections.observableArrayList(new TrabalhadoresRepository().getAll()));
//            return null;
//        }).start();
//
//        trabalhadorTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//        cpfTrabalhadorTableColumn.setCellValueFactory(new PropertyValueFactory<>("cPF"));
//        phoneNumberTrabalhadorTableColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
//        emailTrabalhadorTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        trabalhadorImageView.setOnMouseClicked(event -> {
//            FileChooser fileChooser = new FileChooser();
//            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
//            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG Files", "*.jpg", "*.jpeg", "*.jpe", "*.jif", "*.jfif", "*.jfi"));
//            File file = fileChooser.showOpenDialog(trabalhadorImageView.getScene().getWindow());
//            if (file != null)
//                trabalhadorImageView.setImage(new Image(file.toURI().toString()));
//        });
//
//        SelectionModel selectionModel = trabalhadoresTableView.getSelectionModel();
//        selectionModel.selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue == null)
//                clearFields();
//            else {
//                Trabalhador trabalhador = (Trabalhador) newValue;
//                Address trabalhadorAddress = trabalhador.getAddress();
//                BankAccount trabalhadorAccount = trabalhador.getBankAccount();
//                Image trabalhadorImage = new Image(getClass().getResourceAsStream("/images/personPlaceholder.png"));
//
//                try {
//                    trabalhadorImage = SwingFXUtils.toFXImage(ImageIO.read(new ByteArrayInputStream(trabalhador.getPicture())), null);
//                } catch (IOException | NullPointerException ignored) {
//                }
//
//                trabalhadorImageView.setImage(trabalhadorImage);
//                nameTrabalhadorTextField.setText(trabalhador.getName());
//                nicknameTrabalhadorTextField.setText(trabalhador.getNickname());
//                birthplaceTrabalhadorTextField.setText(trabalhador.getBirthplace());
//                if (trabalhador.getBirthdate() != null)
//                    birthdateTrabalhadorDatePicker.setValue(trabalhador.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                cpfTrabalhadorTextField.setText(trabalhador.getCPF());
//                rgTrabalhadorTextField.setText(trabalhador.getRG());
//                phoneNumberTrabalhadorTextField.setText(trabalhador.getPhoneNumber());
//                emailTrabalhadorTextField.setText(trabalhador.getEmail());
//                streetTrabalhadorTextField.setText(trabalhadorAddress.getStreet());
//                complementTrabalhadorTextField.setText(trabalhadorAddress.getComplement());
//                neighborhoodTrabalhadorTextField.setText(trabalhadorAddress.getNeighborhood());
//                cityTrabalhadorTextField.setText(trabalhadorAddress.getCity());
//                stateTrabalhadorTextField.setText(trabalhadorAddress.getState());
//                zipCodeTrabalhadorTextField.setText(trabalhadorAddress.getZipCode());
//                motherNameTrabalhadorTextField.setText(trabalhador.getMotherName());
//                fatherNameTrabalhadorTextField.setText(trabalhador.getFatherName());
//                nisTrabalhadorTextField.setText(trabalhador.getNIS());
//                ctpsTrabalhadorTextField.setText(trabalhador.getCTPS());
//                cboTrabalhadorComboBox.setValue(trabalhador.getCBO());
//                if (trabalhador.getHiringDate() != null)
//                    hiringDateTrabalhadorDatePicker.setValue(trabalhador.getHiringDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                if (trabalhador.getTerminationDate() != null)
//                    terminationDateTrabalhadorDatePicker.setValue(trabalhador.getTerminationDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//                bankAccountTrabalhadorComboBox.setValue(trabalhadorAccount.getBank());
//                agencyAccountTrabalhadorTextField.setText(trabalhadorAccount.getAgency());
//                numberAccountTrabalhadorTextField.setText(trabalhadorAccount.getNumber());
//            }
//        });
//
//        Postmon.addListener(zipCodeTrabalhadorTextField, streetTrabalhadorTextField, neighborhoodTrabalhadorTextField, cityTrabalhadorTextField, stateTrabalhadorTextField, null);
//
//        addTrabalhadorButton.setOnAction(event -> {
//            selectionModel.clearSelection();
//            setEditable(true);
//        });
//        editTrabalhadorButton.setOnAction(event -> setEditable(true));
//        saveTrabalhadorButton.setOnAction(event -> {
//            boolean newTrabalhador = false;
//
//            Trabalhador trabalhador = (Trabalhador) selectionModel.getSelectedItem();
//            if (trabalhador == null) {
//                newTrabalhador = true;
//                trabalhador = new Trabalhador();
//                trabalhador.setAddress(new Address(-1));
//                trabalhador.setBankAccount(new BankAccount());
//            }
//
//            byte[] trabalhadorImage = {};
//            try {
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                ImageIO.write(SwingFXUtils.fromFXImage(trabalhadorImageView.getImage(), null), "png", byteArrayOutputStream);
//                trabalhadorImage = byteArrayOutputStream.toByteArray();
//                byteArrayOutputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            trabalhador.setPicture(trabalhadorImage);
//            trabalhador.setName(nameTrabalhadorTextField.getText());
//            trabalhador.setNickname(nicknameTrabalhadorTextField.getText());
//            trabalhador.setBirthplace(birthplaceTrabalhadorTextField.getText());
//            if (birthdateTrabalhadorDatePicker.getValue() != null)
//                trabalhador.setBirthdate(Date.from(birthdateTrabalhadorDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            trabalhador.setCPF(cpfTrabalhadorTextField.getText());
//            trabalhador.setRG(rgTrabalhadorTextField.getText());
//            trabalhador.setPhoneNumber(phoneNumberTrabalhadorTextField.getText());
//            trabalhador.setEmail(emailTrabalhadorTextField.getText());
//            trabalhador.getAddress().setStreet(streetTrabalhadorTextField.getText());
//            trabalhador.getAddress().setComplement(complementTrabalhadorTextField.getText());
//            trabalhador.getAddress().setNeighborhood(neighborhoodTrabalhadorTextField.getText());
//            trabalhador.getAddress().setCity(cityTrabalhadorTextField.getText());
//            trabalhador.getAddress().setState(stateTrabalhadorTextField.getText());
//            trabalhador.getAddress().setZipCode(zipCodeTrabalhadorTextField.getText());
//            trabalhador.setMotherName(motherNameTrabalhadorTextField.getText());
//            trabalhador.setFatherName(fatherNameTrabalhadorTextField.getText());
//            trabalhador.setNIS(nisTrabalhadorTextField.getText());
//            trabalhador.setCTPS(ctpsTrabalhadorTextField.getText());
//            trabalhador.setCBO(cboTrabalhadorComboBox.getValue());
//            if (hiringDateTrabalhadorDatePicker.getValue() != null)
//                trabalhador.setHiringDate(Date.from(hiringDateTrabalhadorDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            if (terminationDateTrabalhadorDatePicker.getValue() != null)
//                trabalhador.setTerminationDate(Date.from(terminationDateTrabalhadorDatePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//            trabalhador.getBankAccount().setOwner(nameTrabalhadorTextField.getText());
//            trabalhador.getBankAccount().setC(cpfTrabalhadorTextField.getText());
//            trabalhador.getBankAccount().setBank(bankAccountTrabalhadorComboBox.getValue());
//            trabalhador.getBankAccount().setAgency(agencyAccountTrabalhadorTextField.getText());
//            trabalhador.getBankAccount().setNumber(numberAccountTrabalhadorTextField.getText());
//
//            try {
//                if (newTrabalhador)
//                    new TrabalhadoresRepository().insert(trabalhador);
//                else
//                    new TrabalhadoresRepository().update(trabalhador);
//                trabalhadoresTableView.setItems(FXCollections.observableArrayList(new TrabalhadoresRepository().getAll()));
//            } catch (SQLException e) {
//                StageTools.throwable(e, true);
//            }
//
//            setEditable(false);
//        });
//        deleteTrabalhadorButton.setOnAction(event -> {
//            Trabalhador trabalhador = (Trabalhador) selectionModel.getSelectedItem();
//            if (trabalhador == null) {
//                clearFields();
//                setEditable(false);
//            } else {
//                try {
//                    new TrabalhadoresRepository().remove(trabalhador);
//                    trabalhadoresTableView.setItems(FXCollections.observableArrayList(new TrabalhadoresRepository().getAll()));
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
//        //<editor-fold desc="maritalStatusTrabalhador">
//        maritalStatusTrabalhadorComboBox.setItems(FXCollections.observableArrayList(MaritalStatus.values()));
//        new ComboBoxAutoComplete<>(maritalStatusTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="educationalLevelTrabalhador">
//        educationalLevelTrabalhadorComboBox.setItems(FXCollections.observableArrayList(EducationalLevel.values()));
//        new ComboBoxAutoComplete<>(educationalLevelTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="raceTrabalhador">
//        raceTrabalhadorComboBox.setItems(FXCollections.observableArrayList(Race.values()));
//        new ComboBoxAutoComplete<>(raceTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="genderTrabalhador">
//        genderTrabalhadorComboBox.setItems(FXCollections.observableArrayList(Gender.values()));
//        new ComboBoxAutoComplete<>(genderTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="cboTrabalhador">
//        cboTrabalhadorComboBox.setItems(FXCollections.observableArrayList(CBO.values()));
//        new ComboBoxAutoComplete<>(cboTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="situationTrabalhador">
//        situationTrabalhadorComboBox.setItems(FXCollections.observableArrayList(Situation.values()));
//        new ComboBoxAutoComplete<>(situationTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="bankTrabalhador">
//        bankAccountTrabalhadorComboBox.setItems(FXCollections.observableArrayList(Bank.values()));
//        new ComboBoxAutoComplete<>(bankAccountTrabalhadorComboBox);
//        //</editor-fold>
//
//        //<editor-fold desc="relationshipDependentesTrabalhador">
//        relationshipDependentesTrabalhadorComboBox.setItems(FXCollections.observableArrayList(Relationship.values()));
//        new ComboBoxAutoComplete<>(relationshipDependentesTrabalhadorComboBox);
//        //</editor-fold>
    }
//
//    //<editor-fold desc="trabalhadoresTableView">
//    private void clearFields() {
//        trabalhadorImageView.setImage(new Image(getClass().getResourceAsStream("/images/personPlaceholder.png")));
//        nameTrabalhadorTextField.setText("");
//        nicknameTrabalhadorTextField.setText("");
//        birthplaceTrabalhadorTextField.setText("");
//        birthdateTrabalhadorDatePicker.setValue(null);
//        cpfTrabalhadorTextField.setText("");
//        rgTrabalhadorTextField.setText("");
//        phoneNumberTrabalhadorTextField.setText("");
//        emailTrabalhadorTextField.setText("");
//        streetTrabalhadorTextField.setText("");
//        complementTrabalhadorTextField.setText("");
//        neighborhoodTrabalhadorTextField.setText("");
//        cityTrabalhadorTextField.setText("");
//        stateTrabalhadorTextField.setText("");
//        zipCodeTrabalhadorTextField.setText("");
//        motherNameTrabalhadorTextField.setText("");
//        fatherNameTrabalhadorTextField.setText("");
//        nisTrabalhadorTextField.setText("");
//        ctpsTrabalhadorTextField.setText("");
//        cboTrabalhadorComboBox.setValue(CBO._null);
//        hiringDateTrabalhadorDatePicker.setValue(null);
//        terminationDateTrabalhadorDatePicker.setValue(null);
//        bankAccountTrabalhadorComboBox.setValue(Bank._null);
//        agencyAccountTrabalhadorTextField.setText("");
//        numberAccountTrabalhadorTextField.setText("");
//    }
//
//    private void setEditable(boolean b) {
//        trabalhadorImageView.setDisable(!b);
//        nameTrabalhadorTextField.setEditable(b);
//        nicknameTrabalhadorTextField.setEditable(b);
//        birthplaceTrabalhadorTextField.setEditable(b);
//        birthdateTrabalhadorDatePicker.setDisable(!b);
//        cpfTrabalhadorTextField.setEditable(b);
//        rgTrabalhadorTextField.setEditable(b);
//        phoneNumberTrabalhadorTextField.setEditable(b);
//        emailTrabalhadorTextField.setEditable(b);
//        streetTrabalhadorTextField.setEditable(b);
//        complementTrabalhadorTextField.setEditable(b);
//        neighborhoodTrabalhadorTextField.setEditable(b);
//        cityTrabalhadorTextField.setEditable(b);
//        stateTrabalhadorTextField.setEditable(b);
//        zipCodeTrabalhadorTextField.setEditable(b);
//        motherNameTrabalhadorTextField.setEditable(b);
//        fatherNameTrabalhadorTextField.setEditable(b);
//        nisTrabalhadorTextField.setEditable(b);
//        ctpsTrabalhadorTextField.setEditable(b);
//        cboTrabalhadorComboBox.setDisable(!b);
//        hiringDateTrabalhadorDatePicker.setDisable(!b);
//        terminationDateTrabalhadorDatePicker.setDisable(!b);
//        bankAccountTrabalhadorComboBox.setDisable(!b);
//        agencyAccountTrabalhadorTextField.setEditable(b);
//        numberAccountTrabalhadorTextField.setEditable(b);
//    }
//
//    private void disableButtons(boolean add, boolean edit, boolean save, boolean delete) {
//        addTrabalhadorButton.setDisable(add);
//        editTrabalhadorButton.setDisable(edit);
//        saveTrabalhadorButton.setDisable(save);
//        deleteTrabalhadorButton.setDisable(delete);
//    }
//    //</editor-fold>
}
