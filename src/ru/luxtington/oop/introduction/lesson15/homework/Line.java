package ru.luxtington.oop.introduction.lesson15.homework;

import ru.luxtington.oop.introduction.lesson14.homework.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line
{
    public Point beginPoint;
    public Point endPoint;

    public Line(Point begin, Point end)
    {
        this.beginPoint = begin;
        this.endPoint = end;
    }

    public Line(int x1, int y1, int x2, int y2)
    {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public int calculateLength()
    {
        int length = (int)sqrt(pow((endPoint.x - beginPoint.x), 2) + pow((endPoint.y - beginPoint.y), 2));
        return length;
    }

    public String toString() {
        return "Line from " + beginPoint + " to " + endPoint;
    }
}
