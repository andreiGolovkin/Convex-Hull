/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Andrei Golovkin
 */
public class ConvexHull extends Application {
    private int width = 1200, height = 600;
    private int numPoints = 40;
    private PointsGenerator pg = new PointsGenerator(width, height);
    
    @Override
    public void start(Stage primaryStage) {
        Point2D[] points = pg.createRandomPoints(numPoints);
        
        Point2D[] ch = ConvexHullBuilder.build(points);
        
        Pane root = new Pane();
        
        new Drawer(root).drawLines(ch).drawPoints(points);
        
        Scene scene = new Scene(root, width, height);
        
        primaryStage.setTitle("Convex Hull");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
