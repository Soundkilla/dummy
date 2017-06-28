package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;



public class Controller {
    @FXML
    private Label resultlabel;

    @FXML
    protected void SubmitButton(ActionEvent event) {
        resultlabel.setText("Нажали кнопку");
    }
}
