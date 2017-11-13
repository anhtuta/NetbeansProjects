/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class BarChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Nhóm tuổi");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Tỉ trọng (%) dân số ");
 
        BarChart barChart = new BarChart(xAxis, yAxis);
        
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("2010");
        dataSeries1.getData().add(new XYChart.Data("0 – 14", 24));
        dataSeries1.getData().add(new XYChart.Data("15 – 64"  , 70));
        dataSeries1.getData().add(new XYChart.Data("Trên 64"  , 6));
        barChart.getData().add(dataSeries1);
        
        XYChart.Series dataSeries2 = new XYChart.Series();
        dataSeries2.setName("2020");
        dataSeries2.getData().add(new XYChart.Data("0 – 14", 21));
        dataSeries2.getData().add(new XYChart.Data("15 – 64"  , 71));
        dataSeries2.getData().add(new XYChart.Data("Trên 64"  , 8));
        barChart.getData().add(dataSeries2);
        
        XYChart.Series dataSeries3 = new XYChart.Series();
        dataSeries3.setName("2030");
        dataSeries3.getData().add(new XYChart.Data("0 – 14", 18));
        dataSeries3.getData().add(new XYChart.Data("15 – 64"  , 72));
        dataSeries3.getData().add(new XYChart.Data("Trên 64"  , 10));
        barChart.getData().add(dataSeries3);
        
        VBox vbox = new VBox(barChart);
 
        Scene scene = new Scene(vbox, 600, 410);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("BarChart JavaFx");
        primaryStage.show();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
