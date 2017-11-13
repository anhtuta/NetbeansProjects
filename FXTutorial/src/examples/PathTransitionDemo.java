/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.animation.PathTransitionBuilder;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author AnhTu
 */
public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Image image = new Image("file:\\" + System.getProperty("user.dir") + "\\images\\consider.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        
        Path path = new Path();
        path.setStrokeWidth(1);
        path.setStroke(Color.BLUE);

        FlowPane fp = new FlowPane();
        fp.getChildren().add(imageView);
        Scene scene = new Scene(fp, 400, 400);
        
        scene.onMousePressedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                path.getElements().clear();
                path.getElements().add(new MoveTo(event.getX(), event.getY()));
            }
        });

        scene.onMouseDraggedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                path.getElements().add(new LineTo(event.getX(), event.getY()));
            }
        });

        scene.onMouseReleasedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                PathTransition pathTransition = PathTransitionBuilder.create()
                    .node(imageView)
                    .path(path)
                    .duration(Duration.millis(5000))
                    .orientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT)
                    .cycleCount(1)
                    .build();

                pathTransition.play();
            }
            
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Path Transition Demo");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}