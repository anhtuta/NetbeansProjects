package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FillTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author TUNGDUONG
 */
public class SceneMainController implements Initializable {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Rectangle rectangle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    public void handleButtonClick1(ActionEvent event) {
        makeFade1();
    }

    @FXML
    public void handleButtonClick2(ActionEvent event) {
        makeFade2();
    }

    @FXML
    public void handleButtonClick3(ActionEvent event) {
        makeFade3();
    }

    private void makeFade1() {
        FillTransition ft = new FillTransition(Duration.millis(1000), rectangle, Color.RED, Color.BLUE);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();
    }
    
    private void makeFade2() {
        FillTransition ft = new FillTransition(Duration.millis(2000), rectangle, Color.YELLOW, Color.BLUE);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();
    }
    
    private void makeFade3() {
        FillTransition ft = new FillTransition(Duration.millis(3000), rectangle, Color.GREEN, Color.RED);
        ft.setCycleCount(4);
        ft.setAutoReverse(true);
        ft.play();
    }

}
