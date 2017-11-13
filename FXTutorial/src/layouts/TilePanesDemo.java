/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class TilePanesDemo extends Application {

    Button bt1, bt2, bt3, bt4, bt5;
    
    @Override
    public void init() throws Exception {
        bt1 = new Button("Button 1");
        bt2 = new Button("Button 2");
        bt3 = new Button("Button 3");
        bt4 = new Button("Button 4");
        bt5 = new Button("Button 5");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TilePane tp = new TilePane();
        tp.getChildren().add(bt1);
        tp.getChildren().add(bt2);
        tp.getChildren().add(bt3);
        tp.getChildren().add(bt4);
        tp.getChildren().add(bt5);
        tp.setHgap(30);
        tp.setVgap(10);
        
        primaryStage.setScene(new Scene(tp, 300, 300));
        primaryStage.setTitle("TilePane Demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        TilePanesDemo.launch(args);
    }
}
