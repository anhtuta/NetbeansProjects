/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package open_new_window;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class MyStage1 extends Stage {

    Button btOK, btSave;
    
    public MyStage1() {
        HBox hb = new HBox();
        Label lb = new Label("This is stage 1");
        
        hb.getChildren().add(lb);
        
        this.setScene(new Scene(hb, 300, 300));
        this.setTitle("Stage 1");
    }
}