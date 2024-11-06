package oop.geometricShapes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle extends Figure implements HasPolylineImpl{

    private Point2D secondPoint;
    private Point2D thirdPoint;

    public Triangle(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint){
        super(firstPoint);

        if (!checkTrianglePoints(firstPoint, secondPoint, thirdPoint)){
            super.beginPoint = null;
            throw new IllegalArgumentException("Incorrect points for triangle's build");
        }
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    @Override
    public double area(){
        return 0.5 * Math.abs((secondPoint.x - super.beginPoint.x) * (thirdPoint.y - super.beginPoint.y) - (thirdPoint.x - super.beginPoint.x) * (secondPoint.y - super.beginPoint.y));
    }

    @Override
    public Polyline getPolyline(){

        List<Point2D> trianglePoints = new ArrayList<>(Arrays.asList(super.beginPoint, secondPoint, thirdPoint));

        return new Polyline(trianglePoints);
    }

    private boolean checkTrianglePoints(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint){
        int dist1 = GeometricHelper.distanceBetweenTwoPoints(firstPoint, secondPoint);
        int dist2 = GeometricHelper.distanceBetweenTwoPoints(secondPoint, thirdPoint);
        int dist3 = GeometricHelper.distanceBetweenTwoPoints(firstPoint, thirdPoint);

        if ((dist1 + dist2) > dist3 && (dist2 + dist3) > dist1 && (dist1 + dist3) > dist2)
            return true;
        return false;
    }
}
