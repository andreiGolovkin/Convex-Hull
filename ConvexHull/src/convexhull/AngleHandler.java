/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import javafx.geometry.Point2D;

/**
 *
 * @author Andrei Golovkin
 */
public class AngleHandler {
    public static double calculateAngleBetween(Point2D p1, Point2D p2){
        Point2D vec = vectorizeLine(p1, p2);
        double angle = angle(vec);
        return angle;
    }
    
    private static double angle(Point2D vec) {
        double angle = vec.angle(1, 0);
        if(vec.getY() < 0){
            angle = -angle;
        }
        return angle;
    }
    
    private static Point2D vectorizeLine(Point2D p1, Point2D p2) {
        return p1.subtract(p2).normalize();
    }
}
