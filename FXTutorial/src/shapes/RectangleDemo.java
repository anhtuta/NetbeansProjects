/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class RectangleDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Rectangle rec = new Rectangle(100, 100, 200, 120);
        rec.setStroke(Color.BLUE);
        rec.setFill(Color.CYAN);
        rec.setRotate(30);
        rec.setStrokeWidth(10);
        rec.setArcHeight(10);
        rec.setArcWidth(20);
        rec.setStrokeLineCap(StrokeLineCap.BUTT);
        
        Group g = new Group(rec);
        
        primaryStage.setScene(new Scene(g, 400, 400));
        primaryStage.setTitle("Rectangle Demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
