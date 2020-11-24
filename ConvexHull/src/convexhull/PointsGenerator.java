package convexhull;


import java.util.Random;
import javafx.geometry.Point2D;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrei Golovkin
 */
public class PointsGenerator {
    private final int xrange;
    private final int yrange;
    
    private final Random rand = new Random();
    
    
    public PointsGenerator(int xrange, int yrange) {
        this.xrange = xrange;
        this.yrange = yrange;
    }
    
    private Point2D createRandompoint() {
        Point2D newPoint = new Point2D(3+rand.nextInt(xrange-6), 3+rand.nextInt(yrange-6));
        //newPoint.setFill(Color.RED);
        return newPoint;
    }
    
    public Point2D[] createRandomPoints(int numPoints) {
        Point2D[] points = new Point2D[numPoints];
        
        for (int n = 0; n < numPoints; n++) {
            points[n] = createRandompoint();
        }
        
        return points;
    }
}
