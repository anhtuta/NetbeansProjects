/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class PieChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PieChart pc = new PieChart();
        
        pc.getData().add(new PieChart.Data("Android", 40));
        pc.getData().add(new PieChart.Data("IOS", 35));
        pc.getData().add(new PieChart.Data("Windows Phone", 15));
        pc.getData().add(new PieChart.Data("Symbian", 5));
        pc.getData().add(new PieChart.Data("Nokia", 5));
        
        VBox vbox = new VBox(pc);

        primaryStage.setScene(new Scene(vbox, 600, 450));
        primaryStage.setTitle("PieChart JavaFx");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
