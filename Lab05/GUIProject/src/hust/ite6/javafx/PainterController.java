package hust.ite6.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private RadioButton eraseRadioButton;
    @FXML
    private RadioButton penRadioButton;
    @FXML
    private ToggleGroup toolsToggleGroup;
    @FXML
    private Color color=Color.BLACK;

    @FXML
    void changeTool(ActionEvent event) {
        if (eraseRadioButton.isSelected()) {
            color = Color.WHITE;
        } else if (penRadioButton.isSelected()) {
            color = Color.BLACK;
        }
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(),
                event.getY(), 4, color);
        drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

}
