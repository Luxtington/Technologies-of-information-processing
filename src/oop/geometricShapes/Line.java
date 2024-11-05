package oop.geometricShapes;

public class Line
{
    private Point2D beginPoint;
    private Point2D endPoint;

    public Line(Point2D begin, Point2D end)
    {
        this.beginPoint = new Point2D(begin.x, begin.y);
        this.endPoint = new Point2D(end.x, end.y);
    }

    public Line(int x1, int y1, int x2, int y2)
    {
        this(new Point2D(x1, y1), new Point2D(x2, y2));
    }

    public void setBeginPoint(Point2D point)
    {
        beginPoint = new Point2D(point.x, point.y);
    }

    public void setEndPoint(Point2D point)
    {
        endPoint = new Point2D(point.x, point.y);
    }

    public Point2D getBeginPoint()
    {
        return new Point2D(beginPoint.x, beginPoint.y);
    }

    public Point2D getEndPoint()
    {
        return new Point2D(endPoint.x, endPoint.y);
    }

    public int length()
    {
        return GeometricHelper.distanceBetweenTwoPoints(beginPoint, endPoint);
    }

    public String toString() {
        return "Line from " + beginPoint + " to " + endPoint;
    }
}
