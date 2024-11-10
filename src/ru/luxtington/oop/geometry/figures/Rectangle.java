package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.points.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure implements Polylineable {

    private int firstSide;
    private int secondSide;

    public Rectangle(Point2D leftUpPoint, int firstSide, int secondSide){
        super(leftUpPoint);
        setSides(firstSide, secondSide);
    }

    public int getFirstSide(){
        return firstSide;
    }
    public int getSecondSide(){
        return secondSide;
    }

    public void setFirstSide(int firstSide) {
        if (firstSide < 1)
            throw new IllegalArgumentException("Incorrect side's value");
        this.firstSide = firstSide;
    }

    public void setSecondSide(int secondSide) {
        if (secondSide < 1)
            throw new IllegalArgumentException("Incorrect side's value");
        this.secondSide = secondSide;
    }

    public void setSides(int firstSide, int secondSide){
        setFirstSide(firstSide);
        setSecondSide(secondSide);
    }

    public boolean isSquare(){
        return firstSide == secondSide;
    }

    @Override
    public double area(){
        return firstSide * secondSide;
    }

    @Override
    public Polyline getPolyline() {

        List<Point2D> squarePoints = new ArrayList<>(4);

        squarePoints.add(super.beginPoint);
        squarePoints.add(new Point2D(super.beginPoint.x + firstSide, super.beginPoint.y));
        squarePoints.add(new Point2D(super.beginPoint.x + firstSide, super.beginPoint.y - secondSide));
        squarePoints.add(new Point2D(super.beginPoint.x, super.beginPoint.y - secondSide));

        //return new Polyline(squarePoints);
        return new ClosedLine(squarePoints);
    }

    public String toString() {
        return "Rectangle in point " + super.beginPoint + " with the first side's size = " + firstSide + ", second side's size = " + secondSide;
    }
}
