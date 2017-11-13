/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class EllipseDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Ellipse elip = new Ellipse(200, 200, 80, 50);
        DropShadow ds = new DropShadow(13.0, Color.BLUE);
        elip.setEffect(ds);
        
        VBox vb = new VBox(elip);
        
        primaryStage.setScene(new Scene(vb, 300, 300));
        primaryStage.setTitle("Ellipse Demo");
        primaryStage.show();
        
        Stage stage = new Stage(); // Create a new stage
        stage.setTitle("Second Stage"); // Set the stage title
        // Set a scene with a button in the stage
        stage.setScene(new Scene(new Button("New Stage"), 100, 100));
        stage.show(); // Display the stage
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
