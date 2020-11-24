/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author Andrei Golovkin
 */
public class Drawer {
    private Pane root;
    
    public Drawer(Pane root) {
        this.root = root;
    }
    
    public Drawer drawPoints(Point2D[] points) {
        for (Point2D point : points) {
            Circle circle = new Circle(point.getX(), point.getY(), 3);
            circle.setFill(Color.RED);
            
            root.getChildren().add(circle);
        }
        
        return this;
    }
    
    public Drawer drawLines(Point2D[] points) {
        System.out.println(points.length);
        Point2D prevPoint = null;
        
        for (Point2D currentPoint : points) {
            if (prevPoint != null) {
                Line line = new Line(prevPoint.getX(), prevPoint.getY(), currentPoint.getX(), currentPoint.getY());
                
                root.getChildren().add(line);
            }
            prevPoint = currentPoint;
        }
        
        Line line = new Line(prevPoint.getX(), prevPoint.getY(), points[0].getX(), points[0].getY());
                
        root.getChildren().add(line);
        
        //new Line(currentPoint.getCenterX(), currentPoint.getCenterY(), next.getCenterX(), next.getCenterY())
        return this;
    }
}
