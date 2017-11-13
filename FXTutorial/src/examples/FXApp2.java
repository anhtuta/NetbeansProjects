/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author AnhTu
 */
public class FXApp2 extends Application {

    Button btHello, btBye;

    @Override
    public void init() throws Exception {
        btHello = new Button("Say Hello!");
        btHello.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Dialog d = new Dialog();
//                d.setContentText("Hello world");
//                d.setTitle("Dialog demo");
//                d.setHeaderText("Header text demo");
//                d.show();
                JOptionPane.showMessageDialog(null, "Hello world!");
            }
        });
        
        btBye = new Button("Say Goodbye!");
        btBye.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Goodbye to you!");
            }
        });
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        vbox.getChildren().add(btHello);
        vbox.getChildren().add(btBye);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(new Scene(vbox, 300, 250));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        FXApp2.launch(args);
    }
    
}
