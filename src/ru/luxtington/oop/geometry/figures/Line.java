package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.GeometricHelper;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point2DComparator;
import ru.luxtington.oop.geometry.points.Point3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Line<P extends Point2D> implements Lengthable, Polylineable, Cloneable {

    private P beginPoint;
    private P endPoint;

    public static <P extends Point2D> Line<P> createLine2D(Point2D<> beginPoint, P endPoint){
        return new Line<P>(beginPoint, endPoint);
    }

    public static <P extends Point2D> Line<P> createLine2D(int x1, int y1, int x2, int y2){
        return new Line<P>(x1, y1, x2, y2);
    }

    private Line(P begin, P end) {
       setBeginPoint(begin);
       setEndPoint(end);
    }

    private Line(int x1, int y1, int x2, int y2){
        setBeginPoint((P)new Point2D(x1, y1));
        setEndPoint((P)new Point2D(x2, y2));
    }

    public void setBeginPoint(P begin) {
        this.beginPoint = begin;
    }

    public void setEndPoint(P end) {
        this.endPoint = end;
    }

    public P getBeginPoint() {
        return beginPoint;
    }

    public P getEndPoint() {
        return endPoint;
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
