/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author AnhTu
 */
public class JavaFxFXML extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\demo2\\login.fxml";
            System.out.println("filePath = "+filePath);
            URL url = new File(filePath).toURL();
            System.out.println("url = "+url);
            FXMLLoader fxmlLoader = new FXMLLoader(url);
            Parent parent = (Parent) fxmlLoader.load();
            Scene scene = new Scene(parent, 320, 250);
            primaryStage.setTitle("JavaFX FXML Login Example");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}