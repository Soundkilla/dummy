package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class Controller {
    @FXML
    public Label resultlabel;
    public TextField resultlabelA;
    public TextField resultlabelB;
    public TextField resultlabelC;

    Logger logger = Logger.getLogger(Controller.class.getName());

    @FXML
    protected void SubmitButton(ActionEvent event) {
        try {
            FileHandler fh = new FileHandler("Main.txt");
            logger.addHandler(fh);
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

            logger.setLevel(Level.ALL);
            logger.info("Start logging");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "java.lang.NumberFormatException");

            logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()),e);
            System.exit(0);

        }
        catch (IOException e) {
            logger.log(Level.SEVERE,  Arrays.toString(e.getStackTrace()),e);
        }
        logger.fine("Exception logged");
    }
    }

