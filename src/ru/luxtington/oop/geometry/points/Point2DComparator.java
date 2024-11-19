package ru.luxtington.oop.geometry.points;

import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        if (o1.x == o2.x)
            return o1.y - o2.y;
        return o1.x - o2.y;
    }
}
