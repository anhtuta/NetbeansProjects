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
public class MyStage2 extends Stage {

    Button btOK, btSave;
    
    public MyStage2() {
        HBox hb = new HBox();
        Label lb = new Label("This is stage 2.\nCứ coi như mỗi Stage là 1 JPanel thôi!\n"
                + "Và trong 1 app có nhiều Stage tương ứng với trong 1 JFrame có nhiều JPanel,\n"
                + "muốn cho stage hiện lên hay ẩn đi giống như cho 1 JPanel ẩn hoặc hiện.\n"
                + "Khác nhau ở chỗ là các JPanel ở trong cùng 1 window (trong 1 frame)\n"
                + "còn các stage lại ở các window khác nhau (dù vẫn ở trong 1 Application)");
        
        hb.getChildren().add(lb);
        
        this.setScene(new Scene(hb, 500, 300));
        this.setTitle("Stage 2");
    }
}