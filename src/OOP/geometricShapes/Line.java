package OOP.geometricShapes;

public class Line
{
    private Point beginPoint;
    private Point endPoint;

    public Line(Point begin, Point end)
    {
        this.beginPoint = new Point(begin.x, begin.y);
        this.endPoint = new Point(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2)
    {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public void setBeginPoint(Point point)
    {
        beginPoint = new Point(point.x, point.y);
    }

    public void setEndPoint(Point point)
    {
        endPoint = new Point(point.x, point.y);
    }

    public Point getBeginPoint()
    {
        return new Point(beginPoint.x, beginPoint.y);
    }

    public Point getEndPoint()
    {
        return new Point(endPoint.x, endPoint.y);
    }

    public int length()
    {
        return GeometricHelper.distanceBetweenTwoPoints(beginPoint, endPoint);
    }

    public String toString() {
        return "Line from " + beginPoint + " to " + endPoint;
    }
}
