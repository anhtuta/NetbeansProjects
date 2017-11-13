/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class FlowPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane fp = new FlowPane();
        for (int i = 1; i < 16; i++) {
            fp.getChildren().add(new Button("Button "+i));
        }
        fp.setHgap(10);
        fp.setVgap(20);
        fp.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse clicked");
            }
        });
        fp.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Mouse moving");
            }
        });
        
        primaryStage.setScene(new Scene(fp, 400, 400));
        primaryStage.setTitle("VBox demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
