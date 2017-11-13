package charts;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnhTu
 */
public class BarChartDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Nhóm tuổi");
        
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Số lượng dân số (triệu người)");
        
        BarChart bc = new BarChart(xAxis, yAxis);
        
        XYChart.Series seri1 = new XYChart.Series();
        ObservableList maleList = seri1.getData();
        seri1.setName("Male");
        maleList.add(new XYChart.Data("0 - 5", 5));
        maleList.add(new XYChart.Data("6 - 12", 12));
        maleList.add(new XYChart.Data("13-17", 17));
        maleList.add(new XYChart.Data("20 - 24", 22));
        maleList.add(new XYChart.Data("25 - 35", 30));
        maleList.add(new XYChart.Data("36 - 50", 26));
        maleList.add(new XYChart.Data("51 - 70", 18));
        maleList.add(new XYChart.Data("71 - 85", 11));
        maleList.add(new XYChart.Data("86 - 90", 6));
        maleList.add(new XYChart.Data("> 90", 1));
        bc.getData().add(seri1);
        
        XYChart.Series seri2 = new XYChart.Series();
        seri2.setName("Female");
        ObservableList femaleList = seri2.getData();
        femaleList.add(new XYChart.Data("0 - 5", 4));
        femaleList.add(new XYChart.Data("6 - 12", 11));
        femaleList.add(new XYChart.Data("13-17", 15));
        femaleList.add(new XYChart.Data("20 - 24", 19));
        femaleList.add(new XYChart.Data("25 - 35", 28));
        femaleList.add(new XYChart.Data("36 - 50", 29));
        femaleList.add(new XYChart.Data("51 - 70", 15));
        femaleList.add(new XYChart.Data("71 - 85", 13));
        femaleList.add(new XYChart.Data("86 - 90", 7));
        femaleList.add(new XYChart.Data("> 90", 3));
        bc.getData().add(seri2);
        
        VBox vbox = new VBox(bc);
        
        primaryStage.setScene(new Scene(vbox, 0, 0));
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
