package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.points.Point2D;

public abstract class Figure {

    public Point2D beginPoint;

    public Figure(Point2D beginPoint){
        this.beginPoint = beginPoint;
    }

    public abstract double area();
}
