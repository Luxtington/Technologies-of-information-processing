package ru.luxtington.oop.geometry.points.testCompar;

public class Point2D implements Comparable<Point2D> {
    public int x;
    public int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point2D p){ // + -> greater, - -> less
        if (this.x == p.x)
            return p.y - this.y;
        return p.x - this.x;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
