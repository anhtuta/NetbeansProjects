/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class LineChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Quý");
 
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lợi nhuận (%)");
 
        LineChart lineChart = new LineChart(xAxis, yAxis);
 
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Lợi nhuận");
 
        dataSeries.getData().add(new XYChart.Data(0, 0));
        dataSeries.getData().add(new XYChart.Data(1, 8.92));
        dataSeries.getData().add(new XYChart.Data(2, 3.66));
        dataSeries.getData().add(new XYChart.Data(3, 7.74));
        dataSeries.getData().add(new XYChart.Data(4, 13.02));
 
        lineChart.getData().add(dataSeries);
 
        VBox vbox = new VBox(lineChart);
 
        Scene scene = new Scene(vbox, 600, 410);
 
        primaryStage.setScene(scene);
        primaryStage.setTitle("LineChart JavaFx");
        primaryStage.show();
 
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
