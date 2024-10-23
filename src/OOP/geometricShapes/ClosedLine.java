package OOP.geometricShapes;

import java.util.List;

public class ClosedLine extends Polyline{

    public ClosedLine(List<Point2D> points)
    {
        super(points);
    }

    @Override
    public int length() {
        return super.length() + GeometricHelper.distanceBetweenTwoPoints(super.points.getFirst(), super.points.getLast());
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
