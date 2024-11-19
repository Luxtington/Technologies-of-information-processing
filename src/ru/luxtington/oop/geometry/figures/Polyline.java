package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point2DComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Polyline implements Lengthable, Polylineable {
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

    @Override
    public int length() {
        int length = 0;
        for (int i = 0; i < points.size() - 1; i++)
            length += GeometricHelper.distanceBetweenTwoPoints(points.get(i), points.get(i+1));

        return length;
    }

    @Override
    public Polyline getPolyline(){

        return new Polyline(points);
    }

    private List<Point2D> addPointIfClosed(Polyline line, List <Point2D> pts){

        List <Point2D> points = new ArrayList<>(pts);

        if (line instanceof ClosedLine)
            points.add(points.get(0));

        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline polyline)) return false;

        List <Point2D> thisPts = addPointIfClosed(this, points);
        List <Point2D> otherPts = addPointIfClosed(polyline, polyline.points);

        List <Point2D> reversedOtherPts = new ArrayList<>(otherPts);
        Collections.reverse(reversedOtherPts);

        return Objects.equals(thisPts, otherPts) || Objects.equals(thisPts, reversedOtherPts);
    }

    @Override
    public int hashCode() {

        List <Point2D> thisPts = addPointIfClosed(this, points);
        int hashCodes = 0;
        for (int i=0; i < thisPts.size(); i++)
            hashCodes += thisPts.get(i).hashCode();

        return hashCodes;
        //return Objects.hashCode(thisPts);
    }

    public String toString() {
        String res = "Polyline: ";
        res += points.toString();
        return res;
    }
}
