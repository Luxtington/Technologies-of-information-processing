package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point2DComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line<T extends Point2D> implements Lengthable, Polylineable, Cloneable {

    private T beginPoint;
    private T endPoint;
    private final Class<T> pointClass;

    public Line(Class<T> pointClass) {
        this.pointClass = pointClass;
    }

    public void setBeginPoint(T begin) {
        if (begin.getClass() != pointClass)
            throw new IllegalArgumentException("U can't push different types");
        beginPoint = begin;

    }

    public void setEndPoint(T end) {
        if (end.getClass() != pointClass)
            throw new IllegalArgumentException("U can't push different types");
        endPoint = end;
    }

    public T getBeginPoint() {
        return beginPoint;
    }

    public T getEndPoint() {
        return endPoint;
    }

    public Class<T> getPointClass(){
        return pointClass;
    }

    @Override
    public int length() {
        return GeometricHelper.distanceBetweenTwoPoints(beginPoint, endPoint);
    }

    @Override
    public Polyline getPolyline(){

        return new Polyline(new ArrayList<>(Arrays.asList(beginPoint, endPoint)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(beginPoint, line.beginPoint) && Objects.equals(endPoint, line.endPoint)) || (Objects.equals(beginPoint, line.endPoint) && Objects.equals(endPoint, line.beginPoint));
    }

    @Override
    public int hashCode() {
        List<Point2D> pts = new ArrayList<>(Arrays.asList(beginPoint, endPoint));
        pts.sort(new Point2DComparator());
        return Objects.hash(pts.get(0), pts.get(1));
    }

    @Override
    public Line clone(){
        try{
            Line clonedLine = (Line)super.clone();
            clonedLine.beginPoint  = this.beginPoint.clone(); //= new Point2D(beginPoint.x, beginPoint.y);
            clonedLine.endPoint = this.endPoint.clone();  //= new Point2D(endPoint.x, endPoint.y);
            return clonedLine;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "Line from " + beginPoint + " to " + endPoint;
    }
}
