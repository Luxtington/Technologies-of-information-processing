package OOP.lesson1_4.classwork;

public class Main
{
    public static void main(String[] args)
    {
        Point p1 = new Point(3, 5);
        Point p2 = new Point(25, 6);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(1, 2, 3, 4);

        System.out.println(l1 + " | " + l2);
    }
}
