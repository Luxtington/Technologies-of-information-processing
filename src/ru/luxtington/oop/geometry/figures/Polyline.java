package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point2DComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Polyline<T extends Point2D> implements Lengthable, Polylineable {
    public List<T> points = new ArrayList<>();

    public Polyline(List<T> points) {
        this.points = points;
    }

    public Polyline() {
        this(new ArrayList<>());
    }

    public void addPoints(T... points) {
        for (int i=0; i < points.length; i++)
            addPoint(points[i]);
    }

    public void addPoint(T point){
        this.points.add(point);
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

    private List<T> addPointIfClosed(Polyline line, List <T> pts){

        List <T> points = new ArrayList<>(pts);

        if (line instanceof ClosedLine)
            points.add(points.get(0));

        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Polyline polyline)) return false;

        List <T> thisPts = addPointIfClosed(this, points);
        List <T> otherPts = addPointIfClosed(polyline, polyline.points);

        List <T> reversedOtherPts = new ArrayList<>(otherPts);
        Collections.reverse(reversedOtherPts);

        return Objects.equals(thisPts, otherPts) || Objects.equals(thisPts, reversedOtherPts);
    }

    @Override
    public int hashCode() {

        List <T> thisPts = addPointIfClosed(this, points);
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
