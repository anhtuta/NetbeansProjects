package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author TUNGDUONG
 */
public class SceneMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\fxml\\rectangle_demo.fxml";
            URL url = new File(filePath).toURL();
            FXMLLoader lodaer = new FXMLLoader(url);
            AnchorPane anchorPane = (AnchorPane) lodaer.load();
            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Scene Demo");
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(SceneMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
