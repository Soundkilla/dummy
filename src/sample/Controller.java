package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.*;

public class Controller {



    @FXML
    public Label resultlabel;
    public TextField resultlabelA;
    public TextField resultlabelB;
    public TextField resultlabelC;
    private Logger logger = Logger.getLogger(Controller.class.getName());

    @FXML
    protected void SubmitButton(ActionEvent event) {
        try {
            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream("config.ini");
                property.load(fis);


            } catch (IOException e) {
                System.err.println("Конфиг не найден");
            }

            FileHandler fh = new FileHandler("Main.txt");
            logger.addHandler(fh);
            Double a = Double.parseDouble(resultlabelA.getText());
            Double b = Double.parseDouble(resultlabelB.getText());
            Double c = Double.parseDouble(resultlabelC.getText());
            boolean ugol = Boolean.valueOf(property.getProperty("pryamoyugol"));

            if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
                if (((Math.pow(a, 2) + Math.pow(b, 2)) < Math.pow(c, 2)) || (((Math.pow(a, 2) + Math.pow(b, 2)) < Math.pow(a, 2))) || ((Math.pow(a, 2) + Math.pow(c, 2)) < Math.pow(b, 2)) || ((Math.pow(a, 2) + Math.pow(c, 2)) < Math.pow(b, 2))) {
                    resultlabel.setText("Тупоугольный");}
                    else if (ugol && ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)) || (((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(a, 2))) || ((Math.pow(a, 2) + Math.pow(c, 2)) == Math.pow(b, 2)) || ((Math.pow(a, 2) + Math.pow(c, 2)) == Math.pow(b, 2))){
                    resultlabel.setText("Тупоугольный");
                }
                else {
                    resultlabel.setText("Не тупоугольный");
                }
            } else {
                resultlabel.setText("Произошла ошибка");
            }

            logger.setLevel(Level.ALL);
            logger.info("Start logging");

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла непредвиденная ошибка");
            TextArea textArea = new TextArea(Arrays.toString(e.getStackTrace()));
            textArea.setWrapText(true);
            alert.getDialogPane().setExpandableContent(textArea);
            alert.showAndWait();
            logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()),e);
            System.exit(0);

        }
        catch (IOException e) {
            logger.log(Level.SEVERE,  Arrays.toString(e.getStackTrace()),e);
        }
        logger.fine("Exception logged");
    }
    @FXML
    protected void CloseMenuPressed(ActionEvent event) {
        resultlabel.setText("Close.error");
    }
    @FXML
    protected void AboutMenuPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("Описание функционала программы");
        alert.setContentText("Программа предназначена для определния типа треугольника" + "\n" + "Определяет треугольник как тупоугольный, или как не тупоугольный.");
        alert.showAndWait();
    }
    }

