package oop.geometricShapes;

public abstract class Figure {

    public Point2D beginPoint;

    public Figure(Point2D beginPoint){
        this.beginPoint = beginPoint;
    }

    public abstract double square();
}
