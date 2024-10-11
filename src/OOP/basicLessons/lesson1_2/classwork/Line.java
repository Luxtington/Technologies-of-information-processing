package OOP.basicLessons.lesson1_2.classwork;

public class Line
{
    public Point startPoint;
    public Point endPoint;

    public Line(Point startPoint, Point endPoint)
    {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public String toString()
    {
        return "Line from " + startPoint + " to " + endPoint;
    }
}
