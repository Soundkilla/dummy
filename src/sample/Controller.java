package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class Controller {
    @FXML
    public Label resultlabel;
    public TextField resultlabelA;
    public TextField resultlabelB;
    public TextField resultlabelC;

    @FXML
    protected void SubmitButton(ActionEvent event) {
        try {
            Double a = Double.parseDouble(resultlabelA.getText());
            Double b = Double.parseDouble(resultlabelB.getText());
            Double c = Double.parseDouble(resultlabelC.getText());

            if (a + b > c && a + c > b && b + c > a) {
                if (((Math.pow(a, 2) + Math.pow(b, 2)) < Math.pow(c, 2)) || (((Math.pow(a, 2) + Math.pow(b, 2)) < Math.pow(a, 2))) || ((Math.pow(a, 2) + Math.pow(c, 2)) < Math.pow(b, 2)) || ((Math.pow(a, 2) + Math.pow(c, 2)) < Math.pow(b, 2))) {
                    resultlabel.setText("Тупоугольный");
                } else {
                    resultlabel.setText("Не тупоугольный");
                }
            } else {
                resultlabel.setText("Ошибка. Обратитесь к админу");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "java.lang.NumberFormatException");
            System.exit(0);
        }
    }
}
