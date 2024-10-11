package OOP.geometricShapes;

public class Square
{
    public Point leftUpPoint;
    private int sideSize;

    public Square(Point leftUpPoint, int sideSize)
    {
        this.leftUpPoint = leftUpPoint;
        this.setSideSize(sideSize);
    }

    public Square(int x, int y, int sideSize)
    {
        this(new Point(x, y), sideSize);
    }

    public int getSideSize()
    {
        return sideSize;
    }

    public void setSideSize(int sideSize)
    {
        if (sideSize < 1) throw new IllegalArgumentException("Incorrect value of side's size");
        this.sideSize = sideSize;
    }

    public Polyline getPolyline()
    {
        Point [] squarePoints = new Point[5];

        squarePoints[0] = leftUpPoint;
        squarePoints[1] = new Point(leftUpPoint.x + sideSize, leftUpPoint.y);
        squarePoints[2] = new Point(leftUpPoint.x + sideSize, leftUpPoint.y - sideSize);
        squarePoints[3] = new Point(leftUpPoint.x, leftUpPoint.y - sideSize);
        squarePoints[4] = leftUpPoint;

        return new Polyline(squarePoints);
    }

    public String toString()
    {
        return "Square in point " + leftUpPoint + " with side's size = " + sideSize;
    }
}
