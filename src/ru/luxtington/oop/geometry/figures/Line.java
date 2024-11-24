package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point2DComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line implements Lengthable, Polylineable, Cloneable {

    private Point2D beginPoint;
    private Point2D endPoint;

    public Line(Point2D begin, Point2D end) {
        this.beginPoint = new Point2D(begin.x, begin.y);
        this.endPoint = new Point2D(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public void setBeginPoint(Point2D point) {
        beginPoint = new Point2D(point.x, point.y);
    }

    public void setEndPoint(Point2D point) {
        endPoint = new Point2D(point.x, point.y);
    }

    public Point2D getBeginPoint() {
        return new Point2D(beginPoint.x, beginPoint.y);
    }

    public Point2D getEndPoint() {
        return new Point2D(endPoint.x, endPoint.y);
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
