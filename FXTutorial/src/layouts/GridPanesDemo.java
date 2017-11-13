/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class GridPanesDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");
        Button button4 = new Button("Button 4");
        Button button5 = new Button("Button 5");
        Button button6 = new Button("Button 6");

        GridPane gridPane = new GridPane();
        gridPane.add(button1, 0, 0, 1, 1);
        gridPane.add(button2, 1, 0, 1, 1);

        gridPane.add(button3, 2, 0, 1, 1);
        gridPane.add(button4, 0, 2, 1, 1);
        gridPane.add(button5, 1, 3, 1, 1);
        gridPane.add(button6, 3, 5, 1, 1);
        gridPane.add(new Button("Button 7"), 1, 6, 1, 1);
        gridPane.add(new Button("Button 8"), 2, 6, 1, 1);
        gridPane.add(new Button("Button 9"), 4, 6, 1, 1);
        //gridPane.getChildren().add(new Button("Button 10"));  ko nên dùng!
        
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        primaryStage.setTitle("GridPane JavaFx");
        primaryStage.setScene(new Scene(gridPane, 400, 400));
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
