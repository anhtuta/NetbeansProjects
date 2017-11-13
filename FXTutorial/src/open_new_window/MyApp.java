/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package open_new_window;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class MyApp extends Application {
    MyStage ms;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ms = new MyStage();
        primaryStage = ms;
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        MyApp.launch(args);
    }
}
