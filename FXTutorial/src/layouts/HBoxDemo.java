/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class HBoxDemo extends Application {
    Button bt1, bt2;
    
    
    @Override
    public void init() throws Exception {
        bt1 = new Button("Button 1");
        bt2 = new Button("Button 2");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(bt1, bt2);
        for (int i = 3; i < 16; i++) {
            hbox.getChildren().add(new Button("Button "+i));
        }
        hbox.setSpacing(20);
        
        primaryStage.setScene(new Scene(hbox, 300, 300));
        primaryStage.setTitle("HBox JavaFx");
        primaryStage.show();
    }
    
    public static void display() {
        main(new String [] {"demo", "att"});
    }
    public static void main(String[] args) {
        launch(args);
    }
}
