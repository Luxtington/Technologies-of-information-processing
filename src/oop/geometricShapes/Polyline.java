package oop.geometricShapes;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    public List<Point2D> points = new ArrayList<Point2D>();

    public Polyline(List<Point2D> points) {
        this.points = points;
    }

    public Polyline() {
        this(new ArrayList<>());
    }

    public void addPoints(Point2D... points) {
        for (int i=0; i < points.length; i++)
            this.points.add(points[i]);
    }

    public int length() {
        int length = 0;
        for (int i = 0; i < points.size() - 1; i++)
            length += GeometricHelper.distanceBetweenTwoPoints(points.get(i), points.get(i+1));

        return length;
    }

    public String toString() {
        String res = "Polyline: ";
        res += points.toString();
        return res;
    }
}
