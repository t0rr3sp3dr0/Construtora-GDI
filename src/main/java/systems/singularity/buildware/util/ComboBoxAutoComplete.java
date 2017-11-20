package systems.singularity.buildware.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Window;

import java.util.stream.Stream;

/**
 * Created by pedro on 5/10/16.
 * © 2016 Singularity Systems
 */
public class ComboBoxAutoComplete<T> {
    private final ComboBox<T> comboBox;
    private final ObservableList<T> originalItems;
    private String filter = "";

    public ComboBoxAutoComplete(ComboBox<T> comboBox) {
        this.comboBox = comboBox;
        originalItems = FXCollections.observableArrayList(comboBox.getItems());
        comboBox.setOnKeyPressed(this::handleOnKeyPressed);
        comboBox.setOnHidden((e) -> handleOnHiding());
    }

    private void handleOnKeyPressed(KeyEvent e) {
        ObservableList<T> filteredList = FXCollections.observableArrayList();
        KeyCode code = e.getCode();

        if (comboBox.getTooltip() == null)
            comboBox.setTooltip(new Tooltip());

        if (code.isLetterKey() || code.isDigitKey() || code == KeyCode.SPACE)
            filter += e.getText();
        else if (code == KeyCode.BACK_SPACE && filter.length() > 0) {
            filter = filter.substring(0, filter.length() - 1);
            comboBox.getItems().setAll(originalItems);
        } else if (code == KeyCode.ESCAPE)
            filter = "";

        if (filter.length() == 0)
            comboBox.getTooltip().hide();
        else {
            Stream<T> items = comboBox.getItems().stream();
            String input = filter.toUpperCase();
            items.filter(t -> t.toString().toUpperCase().contains(input)).forEach(filteredList::add);
            Window stage = comboBox.getScene().getWindow();
            Bounds bounds = comboBox.localToScene(comboBox.getBoundsInLocal());
            double posX = stage.getX() + bounds.getMinX();
            double posY = stage.getY() + bounds.getMinY();
            comboBox.getTooltip().setText(input);
            comboBox.getTooltip().show(stage, posX, posY);
            comboBox.show();
            comboBox.getItems().setAll(filteredList);
        }
    }

    private void handleOnHiding() {
        filter = "";
        comboBox.getItems().setAll(originalItems);
        if (comboBox.getTooltip() != null) {
            comboBox.getTooltip().hide();
            comboBox.setTooltip(null);
        }
    }
}
