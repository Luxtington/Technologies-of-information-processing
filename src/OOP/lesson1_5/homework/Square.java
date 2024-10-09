package OOP.lesson1_5.homework;

import OOP.lesson1_3.homework.Point;
import OOP.lesson1_3.homework.Polyline;


public class Square
{
    public Point leftUpPoint;
    public int sideSize;

    public Square(Point leftUpPoint, int sideSize)
    {
        this.leftUpPoint = leftUpPoint;
        if (sideSize < 1) throw new IllegalArgumentException("Incorrect value of side's size");
        this.sideSize = sideSize;
    }

    public Square(int x, int y, int sideSize)
    {
        this(new Point(x, y), sideSize);
    }

    public Polyline getPolyline()
    {
        Point [] squarePoints = new Point[4];

        squarePoints[0] = leftUpPoint;
        squarePoints[1] = new Point(leftUpPoint.x + sideSize, leftUpPoint.y);
        squarePoints[2] = new Point(leftUpPoint.x + sideSize, leftUpPoint.y - sideSize);
        squarePoints[3] = new Point(leftUpPoint.x, leftUpPoint.y - sideSize);

        return new Polyline(squarePoints);
    }

    public String toString()
    {
        return "Square in point " + leftUpPoint + ", with side's size = " + sideSize;
    }
}
