package OOP.geometricShapes;

import java.util.List;

public class ClosedLine extends Polyline{

    public ClosedLine(List<Point2D> points)
    {
        super(points);
    }

    @Override
    public int length() {
        if (super.points.size() < 3) return super.length();
        return super.length() + GeometricHelper.distanceBetweenTwoPoints(super.points.get(0), super.points.get(super.points.size() - 1));
    }

    /*@Override
    public String toString()
    {
        String res = "Closed line: ";
        List <Point> resPoints = new ArrayList<>(super.points);
        resPoints.add(super.points.get(0));
        res += resPoints.toString();
        return res;
    }*/
}
