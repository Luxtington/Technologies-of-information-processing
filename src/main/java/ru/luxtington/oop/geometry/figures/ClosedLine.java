package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;

import java.util.ArrayList;
import java.util.List;

public class ClosedLine extends Polyline {

    public ClosedLine(List<Point2D> points)
    {
        super(points);
    }

    @Override
    public int length() {
        if (super.points.size() < 3) return super.length();
        return super.length() + GeometricHelper.distanceBetweenTwoPoints((Point2D) super.points.get(0), (Point2D) super.points.get(super.points.size() - 1));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString()
    {
        String res = "Closed line: ";
        res += super.points.toString();
        return res;
    }
}
