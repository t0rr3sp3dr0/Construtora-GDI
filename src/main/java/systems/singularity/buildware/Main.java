package systems.singularity.buildware;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import systems.singularity.buildware.db.Database;
import systems.singularity.buildware.gui.MainController;
import systems.singularity.buildware.util.AsyncCallable;
import systems.singularity.buildware.util.AsyncTimeline;
import systems.singularity.buildware.util.StageTools;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class Main extends Application {
    private static final boolean developerMode = true;
    private static final boolean waitOnExcept = true;

    public static void main(String[] args) {
        launch(args);
    }

    public static boolean isDeveloperMode() {
        return developerMode;
    }

    public static boolean isWaitOnExcept() {
        return waitOnExcept;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            if (developerMode)
                e.printStackTrace();

            StageTools.throwable(e, waitOnExcept);
        });

        MainController.stageTools.setStage(primaryStage);

        primaryStage.setOnCloseRequest(event -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText("Are you sure you want to exit?");
            alert.setContentText(null);

            Button exitButton = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
            exitButton.setText("Exit");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new AsyncCallable(() -> {
                    try {
                        Database.getConnection().close();
                    } catch (SQLException ignored) {
                    }

                    return null;
                });

                primaryStage.close();
            } else
                event.consume();
        });

        Parent splashScreen = FXMLLoader.load(getClass().getResource("/scenes/splashScreen.fxml"), ResourceBundle.getBundle("values.fxml"));
        splashScreen.minHeight(Double.parseDouble("480"));
        splashScreen.minWidth(Double.parseDouble("480"));
        splashScreen.maxHeight(Double.parseDouble("480"));
        splashScreen.maxWidth(Double.parseDouble("480"));
        Stage splashStage = new Stage();
        splashStage.setScene(new Scene(
                splashScreen,
                Double.parseDouble("480"),
                Double.parseDouble("480")
        ));
        splashStage.initStyle(StageStyle.TRANSPARENT);
        splashStage.setMinWidth(Double.parseDouble("480"));
        splashStage.setMinHeight(Double.parseDouble("480"));
        splashStage.setMaxWidth(Double.parseDouble("480"));
        splashStage.setMaxHeight(Double.parseDouble("480"));
        splashStage.show();

        Properties messages = new Properties();
        messages.loadFromXML(getClass().getResourceAsStream("/values/messages.xml"));
        Parent root = FXMLLoader.load(getClass().getResource("/scenes/main.fxml"));
        root.minHeight(Double.parseDouble(messages.getProperty("minHeight")));
        root.minWidth(Double.parseDouble(messages.getProperty("minWidth")));
        primaryStage.setTitle(messages.getProperty("app_name"));
        primaryStage.setMaxWidth(Double.parseDouble(messages.getProperty("maxWidth")));
        primaryStage.setMaxHeight(Double.parseDouble(messages.getProperty("maxHeight")));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/icon.png")));
        try {
            MainController.stageTools.setupOSXStage();
        } catch (Exception ignored) {
        }
        primaryStage.setScene(new Scene(
                root,
                Double.parseDouble(messages.getProperty("prefWidth")),
                Double.parseDouble(messages.getProperty("prefHeight"))
        ));
        primaryStage.setMinWidth(Double.parseDouble(messages.getProperty("minWidth")));
        primaryStage.setMinHeight(Double.parseDouble(messages.getProperty("minHeight")));

        Label progressStatus = (Label) splashScreen.lookup("#progressStatus");
        Preferences prefs = Preferences.userNodeForPackage(Main.class);

        AsyncTimeline asyncTimeline = new AsyncTimeline();
        asyncTimeline.add(event -> {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("values.main");
            ((Label) splashScreen.lookup("#version")).setText(String.format("Version %s", resourceBundle.getString("app.version")));
            ((Label) splashScreen.lookup("#licensedTo")).setText(String.format("Licensed to %s", resourceBundle.getString("instance.licensedTo")));
        });
        asyncTimeline.add(event -> progressStatus.setText("Verificando Conexão com o Banco de Dados"), () -> {
            try {
                boolean verifyConnection = Database.verifyConnection(prefs.get("hostConnection", "oracle11g.cin.ufpe.br"), prefs.get("portConnection", "1521"), prefs.get("sidConnection", "Instance01"), prefs.get("userConnection", "g172if686cc_eq01"), prefs.get("passwordConnection", "rwzgrjls"));
                if (!verifyConnection)
                    Platform.runLater(() -> StageTools.alert(Alert.AlertType.ERROR, null, "Conexão com Banco de Dados Falhou", "Verifique sua conexão com o servidor e tente novamente", false));
            } catch (Throwable t) {
                Platform.runLater(() -> StageTools.alert(Alert.AlertType.ERROR, null, "Conexão com Banco de Dados Falhou", "Verifique sua conexão com o servidor e tente novamente", false));
            }

            return null;
        });
        asyncTimeline.add(event -> progressStatus.setText("Carregando User Interface"), () -> {
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.millis(250), new KeyValue(splashStage.opacityProperty(), 0)));
            timeline.setOnFinished(e -> {
                splashStage.close();
                primaryStage.show();
            });
            timeline.play();

            return null;
        });

        asyncTimeline.start();
    }
}
