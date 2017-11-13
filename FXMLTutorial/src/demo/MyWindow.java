/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class MyWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        String filePath = System.getProperty("user.dir") + "\\src\\demo\\FXMLDocument.fxml";
        URL url = new File(filePath).toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent parent = (Parent) loader.load();

        primaryStage.setScene(new Scene(parent, 300, 300));
        primaryStage.setTitle("FXML Demo");
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
