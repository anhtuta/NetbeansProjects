/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */

public class AreaChartDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Tháng");
 
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Nhiệt độ (*C)");
        
        AreaChart ac = new AreaChart(xAxis, yAxis);
        
        XYChart.Series seri = new XYChart.Series();
        seri.setName("Nhiệt độ trung bình của Hà Nội");
        seri.getData().add(new XYChart.Data("1", 16.9));
        seri.getData().add(new XYChart.Data("2", 18));
        seri.getData().add(new XYChart.Data("3", 22));
        seri.getData().add(new XYChart.Data("4", 24));
        seri.getData().add(new XYChart.Data("5", 27.5));
        seri.getData().add(new XYChart.Data("6", 29.5));
        seri.getData().add(new XYChart.Data("7", 31));
        seri.getData().add(new XYChart.Data("8", 29));
        seri.getData().add(new XYChart.Data("9", 27));
        seri.getData().add(new XYChart.Data("10", 25.5));
        seri.getData().add(new XYChart.Data("11", 22));
        seri.getData().add(new XYChart.Data("12", 18.5));
        
        ac.getData().add(seri);
        
        VBox vbox = new VBox(ac);
        primaryStage.setScene(new Scene(vbox, 600, 410));
        primaryStage.setTitle("AreaChart JavaFx");
        primaryStage.show();
 
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
        
    
}
