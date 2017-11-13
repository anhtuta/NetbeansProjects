/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package open_new_window;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import layouts.HBoxDemo;

/**
 *
 * @author AnhTu
 */
public class MyApp1 extends Application {

    Button btStage1, btStage2;
    Stage stage1, stage2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage1 = new MyStage1();
        stage2 = new MyStage2();
        
        HBox hb = new HBox();
        btStage1 = new Button("Open Stage 1");
        btStage2 = new Button("Open Stage 2");
        
        btStage1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btStage1Event(primaryStage);
            }
        });
        btStage2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btStage2Event(primaryStage);
            }
        });
        
        hb.getChildren().add(btStage1);
        hb.getChildren().add(btStage2);
        
        primaryStage.setScene(new Scene(hb, 300, 300));
        primaryStage.setTitle("Stage demo!");
        primaryStage.show();
    }
    
    public void btStage1Event(Stage primaryStage) {
        primaryStage = stage1;
        primaryStage.show();
    }
    
    public void btStage2Event(Stage primaryStage) {
        primaryStage = stage2;
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
