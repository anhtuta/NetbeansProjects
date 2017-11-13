/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class LineDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Line line = new Line(50, 50, 200, 200);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        line.setStroke(Color.RED);
        line.setStrokeWidth(10);
        
        VBox vb = new VBox(line);
        
        primaryStage.setScene(new Scene(vb, 300, 300));
        primaryStage.setTitle("Line Demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
