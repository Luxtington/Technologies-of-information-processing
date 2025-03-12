package ru.luxtington.oop.introduction.lesson13.homework;

import java.util.Arrays;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Polyline
{
    public Point [] points;

    public Polyline(Point [] points)
    {
        this.points = points;
    }

    public Polyline()
    {
        this(null);
    }

    public void addPoints(Point ... points)
    {
        Point [] newPoints = new Point[this.points.length + points.length];
        int i, k=0;
        for (i=0; i<this.points.length; i++)
            newPoints[i] = this.points[i];

        for (int j=i; j < newPoints.length; j++)
            newPoints[j] = points[k++];

        this.points = newPoints;
    }

    public int getLength()
    {
        int length = 0;
        for (int i=0; i<points.length-1; i++)
            length += calculateLength(points[i], points[i+1]);

        return length;
    }

    public int calculateLength(Point beginPoint, Point endPoint)
    {
        int length = (int)sqrt(pow((endPoint.x - beginPoint.x), 2) + pow((endPoint.y - beginPoint.y), 2));
        return length;
    }

    public String toString()
    {
        String res = "Polyline: ";
        res += Arrays.toString(points);
        return res;
    }
}
