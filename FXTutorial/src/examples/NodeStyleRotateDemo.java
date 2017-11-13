/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class NodeStyleRotateDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane sp = new StackPane();
        Button btOk = new Button("OK");
        btOk.setStyle("-fx-border-color: blue; -fx-background-color:#00dddd;");
        
        sp.getChildren().add(btOk);
        sp.setRotate(45);
        sp.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");
        
        primaryStage.setScene(new Scene(sp, 300, 300));
        primaryStage.setTitle("NodeStyleRotateDemo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
