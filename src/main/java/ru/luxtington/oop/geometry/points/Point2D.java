package ru.luxtington.oop.geometry.points;

import ru.luxtington.oop.geometry.figures.Axis;
import ru.luxtington.oop.geometry.figures.Moveable;

import java.util.Objects;

public class Point2D implements Cloneable, Moveable {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveFigure(Axis axis, int step) {
        if (axis == Axis.X_AXIS)
            this.x += step;
        else
            this.y += step;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2D point2D = (Point2D) o;
        return x == point2D.x && y == point2D.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public final Point2D clone() {
        try {
            return (Point2D) super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
