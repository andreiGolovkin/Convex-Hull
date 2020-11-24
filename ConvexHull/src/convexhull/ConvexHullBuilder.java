/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convexhull;

import java.util.Arrays;
import javafx.geometry.Point2D;

/**
 *
 * @author Andrei Golovkin
 */
public class ConvexHullBuilder {
    private static Point2D findHighestPoint(Point2D[] points) {
        Point2D highestPoint = null;
        
        for (Point2D point : points) {
            if (highestPoint == null || highestPoint.getY() > point.getY()) {
                highestPoint = point;
            }
        }
        
        return highestPoint;
    }
    
    private static void sortByAngle(Point2D[] points, final Point2D highestPoint) {
        Arrays.sort(points, (Point2D p1, Point2D p2) -> {
            int ans = 0;
            
            double angle1 = AngleHandler.calculateAngleBetween(highestPoint, p1);
            double angle2 = AngleHandler.calculateAngleBetween(highestPoint, p2);
            
            if(highestPoint == p2 || angle1 > angle2) {
                ans = 1;
            } else if (highestPoint == p1 || angle1 < angle2) {
                ans = -1;
            }
            
            return ans;
        });
    }
    
    public static Point2D[] build(Point2D[] points) {
        PointSelector ch = new PointSelector();
        Point2D highestPoint = findHighestPoint(points);
        sortByAngle(points, highestPoint);
        for (Point2D point : points) {
            if (ch.isEmpty()) ch.push(point, 0);
            
            double prevAngle = ch.getLastAngle();
            Point2D prevPoint = ch.getLastPoint();

            double angle = AngleHandler.calculateAngleBetween(prevPoint, point);
            double relAngle = angle - prevAngle;
            
            while (relAngle < 0) {
                ch.pop();

                prevAngle = ch.getLastAngle();
                prevPoint = ch.getLastPoint();

                angle = AngleHandler.calculateAngleBetween(prevPoint, point);
                relAngle = angle - prevAngle;
            }

            ch.push(point, angle);
        }
        
        Point2D[] chPoints = ch.asPoints();
        return chPoints;
    }
}
