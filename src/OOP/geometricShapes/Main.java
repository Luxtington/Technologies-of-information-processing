package OOP.geometricShapes;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        ClosedLine cl1 = new ClosedLine(new ArrayList<Point2D>(Arrays.asList(new Point2D(1,2), new Point2D(3, 4), new Point2D(5, 6))));
        System.out.println(cl1);

        /*Square sq1 = new Square(new Point(6,7), 9);
        System.out.println(sq1.getPolyline());*/

        /*Point p1 = new Point(1,5), p2 = new Point(6, 7);
        Line l1 = new Line(p1, p2);
        l1.setBeginPoint(new Point(2, 10));
        l1.setEndPoint(new Point(12, 14));
        System.out.println(l1.getBeginPoint() + " - " + l1.getEndPoint());*/

        //Point3D p1 = new Point3D(1,2,3);
        //System.out.println(p1);
        //System.out.println();

    }
}
