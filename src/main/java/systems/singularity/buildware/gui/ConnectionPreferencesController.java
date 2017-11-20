package systems.singularity.buildware.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import systems.singularity.buildware.Main;
import systems.singularity.buildware.db.Database;
import systems.singularity.buildware.util.StageTools;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

/**
 * Created by caesa on 02/05/2016.
 * © 2016 Singularity Systems
 */
public class ConnectionPreferencesController implements Initializable {
    @FXML
    private TextField hostTextField;
    @FXML
    private TextField portTextField;
    @FXML
    private TextField userTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField sidTextField;
    @FXML
    private Button commitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        hostTextField.setText(prefs.get("hostConnection", "oracle11g.cin.ufpe.br"));
        portTextField.setText(prefs.get("portConnection", "1521"));
        sidTextField.setText(prefs.get("sidConnection", "Instance01"));
        userTextField.setText(prefs.get("userConnection", "g172if686cc_eq01"));
        passwordPasswordField.setText(prefs.get("passwordConnection", "rwzgrjls"));

        commitButton.setOnAction(event -> {
            if (Database.verifyConnection(
                    hostTextField.getText(),
                    portTextField.getText(),
                    sidTextField.getText(),
                    userTextField.getText(),
                    passwordPasswordField.getText()
            )) {
                prefs.put("domainConnection", hostTextField.getText());
                prefs.put("portConnection", portTextField.getText());
                prefs.put("userConnection", userTextField.getText());
                prefs.put("passwordConnection", passwordPasswordField.getText());
                prefs.put("databaseConnection", sidTextField.getText());

                try {
                    Database.getConnection().close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                StageTools.alert(
                        Alert.AlertType.INFORMATION,
                        null,
                        "Database settings committed successfully!",
                        "Restarting the application...",
                        true
                );

                MainController.stageTools.restartStage();
            } else {
                StageTools.alert(
                        Alert.AlertType.ERROR,
                        null,
                        "Database unsuccessful!",
                        "Please verify your connection settings and try again",
                        true
                );
            }
        });
    }
}
