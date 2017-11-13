/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author AnhTu
 */
public class AreaChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Tháng");
 
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Lượng mưa (mm)");
 
        AreaChart areaChart = new AreaChart(xAxis, yAxis);
 
        XYChart.Series dataSeries = new XYChart.Series();
        dataSeries.setName("Lượng mưa trung bình TPHCM");
 
        dataSeries.getData().add(new XYChart.Data(1, 27));
        dataSeries.getData().add(new XYChart.Data(2, 4));
        dataSeries.getData().add(new XYChart.Data(3, 93));
        dataSeries.getData().add(new XYChart.Data(4, 81));
        dataSeries.getData().add(new XYChart.Data(5, 213));
        dataSeries.getData().add(new XYChart.Data(6, 309));
        dataSeries.getData().add(new XYChart.Data(7, 295));
        dataSeries.getData().add(new XYChart.Data(8, 271));
        dataSeries.getData().add(new XYChart.Data(9, 342));
        dataSeries.getData().add(new XYChart.Data(10, 260));
        dataSeries.getData().add(new XYChart.Data(11, 119));
        dataSeries.getData().add(new XYChart.Data(12, 47));
 
        areaChart.getData().add(dataSeries);
 
        VBox vbox = new VBox(areaChart);
 
        Scene scene = new Scene(vbox, 600, 410);
 
        primaryStage.setScene(scene);
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
