/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class VBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        for (int i = 1; i < 16; i++) {
            vbox.getChildren().add(new Button("Button "+i));
        }
        vbox.setSpacing(10);
        primaryStage.setScene(new Scene(vbox, 400, 400));
        primaryStage.setTitle("VBox demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
