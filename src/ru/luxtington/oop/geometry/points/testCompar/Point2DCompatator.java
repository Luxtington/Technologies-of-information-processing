package ru.luxtington.oop.geometry.points.testCompar;

import java.util.Comparator;

public class Point2DCompatator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D p1, Point2D p2) { // + -> greater, - -> less
        if (p1.x == p2.x)
            return p1.y - p2.y;
        return p1.x - p2.x;
    }
}