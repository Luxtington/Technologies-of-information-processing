package OOP.lesson2.homework;

public class Line
{
    public Point startPoint;
    public Point endPoint;

    public Line(Point startPoint, Point endPoint)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public void updateLineCoords(Point newStartPoint, Point newEndPoint)
    {
        startPoint = newStartPoint;
        endPoint = newEndPoint;
    }

    public String toString()
    {
        return "Line from " + startPoint + " to " + endPoint;
    }
}
