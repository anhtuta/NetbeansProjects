/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class FontDemo extends Application {

    @Override
    public void start(Stage st) throws Exception {
        Pane p = new StackPane();
        
        Circle c = new Circle();
        c.setRadius(150);
        c.setStroke(Color.BLUE);
        c.setFill(new Color(0.5, 0.5, 0.5, 0.9));
        
        Label lb = new Label("JavaFX is awesome!");
        lb.setFont(Font.font("Consolas", FontWeight.BOLD, FontPosture.ITALIC, 20));
        
        p.getChildren().add(c);
        p.getChildren().add(lb);
        
        st.setScene(new Scene(p, 400, 500));
        st.setTitle("Font Demo");
        st.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
