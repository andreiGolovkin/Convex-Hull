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
public class LineConnector {
    private Point2D point;
    private double angle;
    
    public LineConnector(Point2D point, double angle) {
        this.point = point;
        this.angle = angle;
    }
    
    public Point2D getPoint() {
        return point;
    }
    
    public double getAngle() {
        return angle;
    }
}
