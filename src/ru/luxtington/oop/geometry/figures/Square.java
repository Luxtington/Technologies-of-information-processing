package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.points.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Square extends Figure implements Moveable{
    //public Point2D leftUpPoint;
    private int sideSize;

    public Square(Point2D leftUpPoint, int sideSize) {
        //this.leftUpPoint = leftUpPoint;
        super(leftUpPoint);
        setSideSize(sideSize);
    }

    public Square(int x, int y, int sideSize) {
        this(new Point2D(x, y), sideSize);
    }

    public int getSideSize() {
        return sideSize;
    }

    public void setSideSize(int sideSize) {
        if (sideSize < 1)
            throw new IllegalArgumentException("Square's side should be greater than 0");
        this.sideSize = sideSize;
    }

    public double area(){
        System.out.println("Calculate area: ");
        return sideSize*sideSize;
    }

    public Point2D getLeftUpPoint(){
        return new Point2D(super.beginPoint.x, super.beginPoint.y);
    }

    @Override
    public void moveFigure(Axis axis, int step) {
        if (axis == Axis.X_AXIS)
            super.beginPoint.x += step;
        else
            super.beginPoint.y += step;
    }

    public Polyline getPolyline() {
        List<Point2D> squarePoints = new ArrayList<>(5);

        squarePoints.set(0, super.beginPoint);
        squarePoints.set(1, new Point2D(super.beginPoint.x + sideSize, super.beginPoint.y));
        squarePoints.set(2, new Point2D(super.beginPoint.x + sideSize, super.beginPoint.y - sideSize));
        squarePoints.set(3, new Point2D(super.beginPoint.x, super.beginPoint.y - sideSize));
        squarePoints.set(4, super.beginPoint);

        return new Polyline(squarePoints);
    }

    public String toString() {
        return "Square in point " + super.beginPoint + " with side's size = " + sideSize;
    }
}
