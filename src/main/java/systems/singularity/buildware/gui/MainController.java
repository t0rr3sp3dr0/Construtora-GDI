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
    private MenuItem dispesasFixasFluxoMenuItem;
    @FXML
    private MenuItem estoqueRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem aboutMenuItem;
    @FXML
    private Menu cadastroMenu;
    @FXML
    private MenuItem imobiliariasCadastroMenuItem;
    @FXML
    private MenuItem obrasCadastroMenuItem;
    @FXML
    private Menu pagamentosMenu;
    @FXML
    private MenuItem pagarContasFluxoMenuItem;
    @FXML
    private Menu caixaMenu;
    @FXML
    private Label wellcomeLabel;
    @FXML
    private MenuItem materiaisCadastroMenuItem;
    @FXML
    private MenuBar menuBar;
    @FXML
    private PasswordField password;
    @FXML
    private MenuItem materiaisRelatoriosDocumentosMenuItem;
    @FXML
    private Tab mainTab;
    @FXML
    private Button loginButton;
    @FXML
    private MenuItem inssRecolhimentoMenuItem;
    @FXML
    private MenuItem irrfRecolhimentoMenuItem;
    @FXML
    private MenuItem folhaPagamentoMenuItem;
    @FXML
    private MenuItem corretoresRelatoriosDocumentosMenuItem;
    @FXML
    private Menu relatoriosMenu;
    @FXML
    private MenuItem connectionPreferencesMenuItem;
    @FXML
    private MenuItem clientesRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem importarDocumentosMenuItem;
    @FXML
    private Menu encargosTrabalhistasMenu;
    @FXML
    private MenuItem receberContasFluxoMenuItem;
    @FXML
    private Menu estoqueMenu;
    @FXML
    private MenuItem tributosPagamentoMenuItem;
    @FXML
    private VBox loginBox;
    @FXML
    private MenuItem fornecedoresCadastroMenuItem;
    @FXML
    private MenuItem fgtsRecolhimentoMenuItem;
    @FXML
    private MenuItem prestadoresServicoRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem diversosPagamentoMenuItem;
    @FXML
    private MenuItem imoveisCadastroMenuItem;
    @FXML
    private Menu mainMenu;
    @FXML
    private MenuItem reciboAvulsoDocumentosMenuItem;
    @FXML
    private MenuItem corretoresCadastroMenuItem;
    @FXML
    private MenuItem saidaEstoqueMenuItem;
    @FXML
    private MenuItem entradaEstoqueMenuItem;
    @FXML
    private MenuItem clientesCadastroMenuItem;
    @FXML
    private MenuItem entradaCapitalFluxoMenuItem;
    @FXML
    private VBox wellcomeBox;
    @FXML
    private MenuItem imoveisRelatoriosDocumentosMenuItem;
    @FXML
    private Menu documentosMenu;
    @FXML
    private MenuItem obrasRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem trabalhadoresRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem prestadoresServicoCadastroMenuItem;
    @FXML
    private Menu developerMenu;
    @FXML
    private MenuItem imobiliariasRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem despesasRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem fornecedoresRelatoriosDocumentosMenuItem;
    @FXML
    private MenuItem quitMenuItem;
    @FXML
    private MenuItem gerarDocumentosMenuItem;
    @FXML
    private MenuItem saidaCapitalFluxoMenuItem;
    @FXML
    private MenuItem trabalhadoresCadastroMenuItem;
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField username;
    private int level = -1;
    private int tries = 0;
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

        stageTools.setupMenuItem("fornecedoresCadastro", fornecedoresCadastroMenuItem);
        stageTools.setupMenuItem("trabalhadoresCadastro", trabalhadoresCadastroMenuItem);
        stageTools.setupMenuItem("trabalhadoresCadastro", trabalhadoresCadastroMenuItem);
        stageTools.setupMenuItem("clientesCadastro", clientesCadastroMenuItem);
        stageTools.setupMenuItem("materiaisCadastro", materiaisCadastroMenuItem);
        stageTools.setupMenuItem("obrasCadastro", obrasCadastroMenuItem);
//        stageTools.setupMenuItem("recolhimentoCadastro", destinosRecolhimentosCadastroMenuItem);
        stageTools.setupMenuItem("corretoresCadastro", corretoresCadastroMenuItem);
        stageTools.setupMenuItem("imobiliariasCadastro", imobiliariasCadastroMenuItem);
        stageTools.setupMenuItem("imoveisCadastro", imoveisCadastroMenuItem);
        stageTools.setupMenuItem("prestadoresServicoCadastro", prestadoresServicoCadastroMenuItem);
        stageTools.setupMenuItem("entradaEstoque", entradaEstoqueMenuItem);
        stageTools.setupMenuItem("saidaEstoque", saidaEstoqueMenuItem);
        stageTools.setupMenuItem("fgtsRecolhimento", fgtsRecolhimentoMenuItem);
        stageTools.setupMenuItem("inssRecolhimento", inssRecolhimentoMenuItem);
        stageTools.setupMenuItem("irrfRecolhimento", irrfRecolhimentoMenuItem);
        stageTools.setupMenuItem("folhaPagamento", folhaPagamentoMenuItem);
        stageTools.setupMenuItem("tributosPagamento", tributosPagamentoMenuItem);
        stageTools.setupMenuItem("diversosPagamento", diversosPagamentoMenuItem);
        stageTools.setupMenuItem("entradaCapitalFluxo", entradaCapitalFluxoMenuItem);
        stageTools.setupMenuItem("saidaCapitalFluxo", saidaCapitalFluxoMenuItem);
        stageTools.setupMenuItem("pagarContasFluxo", pagarContasFluxoMenuItem);
        stageTools.setupMenuItem("receberContasFluxo", receberContasFluxoMenuItem);
        stageTools.setupMenuItem("dispesasFixasFluxo", dispesasFixasFluxoMenuItem);
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

//        if (level == -1) {
//            menuBar.setDisable(true);
//            wellcomeBox.setVisible(false);
//            loginBox.setVisible(true);
//            loginButton.setOnAction(event -> {
//                if (username.getText() == null || username.getText().length() == 0) {
//                    StageTools.alert(Alert.AlertType.WARNING, null, "Usuário é um campo obrigatório", null, true);
//                    tries++;
//                } else if (password.getText() == null || password.getText().length() == 0) {
//                    StageTools.alert(Alert.AlertType.WARNING, null, "Senha é um campo obrigatório", null, true);
//                    tries++;
//                } else {
//                    try {
//                        User user = new User(-1, username.getText(), DigestUtils.shaHex(password.getText()), null);
//                        if ((user.getLogin().equals("user") && user.getPassword().equals("9d4e1e23bd5b727046a9e3b4b7db57bd8d6ee684")) || new UsersRepository().verifyCredentials(user)) {
//                            menuBar.setDisable(false);
//                            wellcomeBox.setVisible(true);
//                            loginBox.setVisible(false);
//                            wellcomeLabel.setText(wellcomeLabel.getText().replace("{{USER}}", "Johnny Appleseed"));
//                        } else {
//                            StageTools.alert(Alert.AlertType.ERROR, null, "Acesso Negado", "Usuário e senha não coincidem ou são inválidos", true);
//                            tries++;
//                            password.setText(null);
//                            password.requestFocus();
//                        }
//                    } catch (SQLException e) {
//                        StageTools.throwable(e, true);
//                    }
//                }
//                if (tries >= 4) {
//                    StageTools.alert(Alert.AlertType.ERROR, null, "Você excedeu o número máximo de tentativas", "Por motivos de segurança a aplicação será agora encerrada", true);
//                    stageTools.close(true);
//                }
//            });
//        } else {
        menuBar.setDisable(false);
        wellcomeBox.setVisible(true);
        loginBox.setVisible(false);
        wellcomeLabel.setText(wellcomeLabel.getText().replace("{{USER}}", "Johnny Appleseed"));

        level = 0;
//        }
    }
}
