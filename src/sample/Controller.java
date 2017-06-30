package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
    @FXML
    private Label resultlabel;
    public TextField resultlabelA;
    public TextField resultlabelB;
    public TextField resultlabelC;
    private Logger logger = Logger.getLogger(Controller.class.getName());
    private Double a = null;
    private Double b = null;
    private Double c = null;
    @FXML
    protected void SubmitButton() {
        try {
            FileHandler fh = new FileHandler("Main.txt");
            logger.addHandler(fh);
            parseDouble();
            resultlabel.setTextFill(Color.BLACK);
            if (isCorrect()){
                if(isDumb()){
                    resultlabel.setText("Тупоугольный");
                } else {
                    resultlabel.setText("Не тупоугольный");
                }
            } else {
                resultlabel.setText("Произошла ошибка");
            }
            logger.setLevel(Level.ALL);
            logger.info("Start logging");

        } catch (NumberFormatException e) {
            getCrashed(e);
        }
        catch (IOException e) {
            logger.log(Level.SEVERE,  Arrays.toString(e.getStackTrace()),e);
        }
        logger.fine("Exception logged");
    }
    @FXML
    protected void CloseMenuPressed() {
        resultlabel.setTextFill(Color.RED);
        resultlabel.setText("Close.error");
    }
    @FXML
    protected void AboutMenuPressed() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("Описание функционала программы");
        alert.setContentText("Программа предназначена для определния типа треугольника" + "\n" + "Определяет треугольник как тупоугольный, или как не тупоугольный.");
        alert.showAndWait();
    }
    private void parseDouble(){
        this.a = Double.parseDouble(resultlabelA.getText());
        this.b = Double.parseDouble(resultlabelB.getText());
        this.c = Double.parseDouble(resultlabelC.getText());
    }
    private boolean isCorrect(){
        return this.a + this.b > this.c && this.a + this.c > this.b && this.b + this.c > this.a;
    }
    private boolean isDumb(){
        this.a = Math.pow(this.a, 2);
        this.b = Math.pow(this.b, 2);
        this.c = Math.pow(this.c, 2);
        return this.a + this.b < this.c ||
                this.a + this.b < this.a ||
                this.a + this.c < this.b ||
                this.a + this.c < this.b;
    }
    private void getCrashed(NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText("Произошла непредвиденная ошибка");
        TextArea textArea = new TextArea(Arrays.toString(e.getStackTrace()));
        textArea.setWrapText(true);
        alert.getDialogPane().setExpandableContent(textArea);
        alert.showAndWait();
        alert.setResizable(false);
        logger.log(Level.SEVERE, Arrays.toString(e.getStackTrace()),e);
        System.exit(0);
    }
}

