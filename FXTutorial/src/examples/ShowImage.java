/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class ShowImage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hb = new HBox();
        hb.setPadding(new Insets(5, 5, 5, 5));
        String imgPath = "file:\\" + System.getProperty("user.dir") + "\\images\\goku.png";
        System.out.println(imgPath);
        Image img = new Image(imgPath);
        ImageView imgView = new ImageView();
        imgView.setImage(img);
        hb.getChildren().add(imgView);
        
        primaryStage.setScene(new Scene(hb));
        primaryStage.setTitle("HBox JavaFx");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
