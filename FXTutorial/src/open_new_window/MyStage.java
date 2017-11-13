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
public class MyStage extends Stage {

    Button btOK, btSave;
    
    public MyStage() {
        HBox hb = new HBox();
        btOK = new Button("Ok");
        btSave = new Button("Save");
        
        hb.getChildren().add(btOK);
        hb.getChildren().add(btSave);
        
        this.setScene(new Scene(hb, 300, 300));
        this.setTitle("Stage demo! Đây là VD t tự nghĩ ra");
    }
}
