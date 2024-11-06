package oop.geometricShapes;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class GeometricHelper
{
    public static int distanceBetweenTwoPoints(Point2D beginPoint, Point2D endPoint)
    {
        return (int)sqrt(pow((endPoint.x - beginPoint.x), 2) + pow((endPoint.y - beginPoint.y), 2));
    }

    public static Polyline joinPolylines(HasPolylineImpl...shapes){
        List<Point2D> points = new ArrayList<>();
        int index = 0;

        for (int i=0; i < shapes.length; i++){
            for (int j=0; j < shapes[i].getPolyline().points.size(); j++){
                points.add(shapes[i].getPolyline().points.get(j));
            }
        }
        return new Polyline(points);
    }
}
