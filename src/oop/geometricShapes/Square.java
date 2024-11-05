package oop.geometricShapes;

import java.util.ArrayList;
import java.util.List;

public class Square extends Rectangle {
    //private int sideSize;

    public Square(Point2D leftUpPoint, int sideSize) {
        super(leftUpPoint, sideSize, sideSize);
    }

    public Square(int x, int y, int sideSize) {
        this(new Point2D(x, y), sideSize);
    }

    public int getSquareSide() {
        return super.getFirstSide();
    }

    public void setSquareSize(int sideSize) {
        super.setSides(sideSize, sideSize);
    }

    public Polyline getPolyline() {
        List<Point2D> squarePoints = new ArrayList<>(5);

        squarePoints.set(0, super.beginPoint);
        squarePoints.set(1, new Point2D(super.beginPoint.x + super.getFirstSide(), super.beginPoint.y));
        squarePoints.set(2, new Point2D(super.beginPoint.x + super.getFirstSide(), super.beginPoint.y - super.getFirstSide()));
        squarePoints.set(3, new Point2D(super.beginPoint.x, super.beginPoint.y - super.getFirstSide()));
        squarePoints.set(4, super.beginPoint);

        return new Polyline(squarePoints);
    }

    public String toString() {
        return "Square in point " + super.beginPoint + " with side's size = " + super.getFirstSide();
    }
}
