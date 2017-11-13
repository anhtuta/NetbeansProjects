/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class LoginFX extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
        Parent parent = (Parent) loader.load();

        primaryStage.setScene(new Scene(parent, 300, 300));
        primaryStage.setTitle("FXML Demo");
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
