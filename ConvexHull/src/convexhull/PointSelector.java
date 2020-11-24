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
public class PointSelector extends Selector<LineConnector> {
    @Override
    public LineConnector getData() {
        return super.getData();
    }
    
    @Override
    public LineConnector last() {
        return super.last();
    }
    
    @Override
    public LineConnector first() {
        return super.first();
    }
    
    public void push(Point2D point, double angle) {
        LineConnector newElement = new LineConnector(point, angle);
        super.push(newElement);
    }
    
    public double getAngle() {
        return this.getData().getAngle();
    }
    
    public Point2D getPoint() {
        return this.getData().getPoint();
    }
    
    public double getFirstAngle() {
        return this.first().getAngle();
    }
    
    public Point2D getFirstPoint() {
        return this.first().getPoint();
    }
    
    public double getLastAngle() {
        return this.last().getAngle();
    }
    
    public Point2D getLastPoint() {
        return this.last().getPoint();
    }
    
    public Point2D[] asPoints() {
        Point2D[] points = new Point2D[this.size()];
        this.goToStart();
        
        for (int n = 0; n < this.size(); n++) {
            points[n] = this.getPoint();
            this.next();
        }
        
        return points;
    }
}
