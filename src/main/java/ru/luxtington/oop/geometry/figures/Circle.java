package ru.luxtington.oop.geometry.figures;

import ru.luxtington.oop.geometry.points.Point2D;

public class Circle extends Figure implements Moveable{

    private int radius;

    public Circle(Point2D centralPoint, int radius){
        super(centralPoint);
        setRadius(radius);
    }

    public void setRadius(int radius){
        if (radius < 1)
            throw new IllegalArgumentException("Incorrect radius's value");
        this.radius = radius;
    }

    @Override
    public void moveFigure(Axis axis, int step) {
        if (axis == Axis.X_AXIS)
            super.beginPoint.x += step;
        else
            super.beginPoint.y += step;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }

    public String toString(){
        return "Circle with center in " + super.beginPoint + ", with radius = " + radius;
    }
}
