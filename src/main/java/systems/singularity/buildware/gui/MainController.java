package systems.singularity.buildware.gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.commons.codec.digest.DigestUtils;
import systems.singularity.buildware.util.StageTools;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Year;
import java.util.Properties;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    public static StageTools stageTools = new StageTools();

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private Menu cadastroMenu;

    @FXML
    private Label wellcomeLabel;

    @FXML
    private MenuBar menuBar;

    @FXML
    private PasswordField password;

    @FXML
    private Tab mainTab;

    @FXML
    private Button loginButton;

    @FXML
    private MenuItem connectionPreferencesMenuItem;

    @FXML
    private VBox loginBox;

    @FXML
    private MenuItem fornecedoresCadastroMenuItem;

    @FXML
    private Menu mainMenu;

    @FXML
    private MenuItem clientesCadastroMenuItem;

    @FXML
    private VBox wellcomeBox;

    @FXML
    private Menu developerMenu;

    @FXML
    private MenuItem quitMenuItem;

    @FXML
    private TabPane tabPane;

    @FXML
    private TextField username;

    private Properties messages = new Properties();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        stageTools.setTabPane(tabPane);

        mainMenu.setText(mainMenu.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        aboutMenuItem.setText(aboutMenuItem.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        aboutMenuItem.setOnAction(event -> StageTools.alert(
                Alert.AlertType.INFORMATION,
                null,
                messages.getProperty("app_name"),
                String.format("© %d %s\nAll rights reserved\n\n<> Developed by %s", Year.now().getValue(), messages.getProperty("app_name"), messages.getProperty("developer_name")),
                true
        ));
        quitMenuItem.setText(quitMenuItem.getText().replace("{{APP_NAME}}", messages.getProperty("app_name")));
        quitMenuItem.setOnAction(event -> {
            Stage stage = (Stage) menuBar.getScene().getWindow();
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        });

        stageTools.setupMenuItem("clientesCadastro", clientesCadastroMenuItem);
        stageTools.setupMenuItem("fornecedoresCadastro", fornecedoresCadastroMenuItem);
        stageTools.setupMenuItem("connectionPreferences", connectionPreferencesMenuItem);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.SELECTED_TAB);

        username.setOnAction(event -> {
            if (username.getText() == null || username.getText().length() == 0)
                StageTools.alert(Alert.AlertType.WARNING, null, "Usuário é um campo obrigatório", null, true);
            else
                password.requestFocus();
        });
        password.setOnAction(event -> {
            if (password.getText() == null || password.getText().length() == 0)
                StageTools.alert(Alert.AlertType.WARNING, null, "Senha é um campo obrigatório", null, true);
            else
                loginButton.fire();
        });

        menuBar.setDisable(false);
        wellcomeBox.setVisible(true);
        loginBox.setVisible(false);
        wellcomeLabel.setText(wellcomeLabel.getText().replace("{{USER}}", "Johnny Appleseed"));
    }
}
