package OOP.lesson3.homework;

import java.util.Arrays;

public class Polyline
{
    public Point [] points;

    public Polyline(Point [] points)
    {
        this.points = points;
    }

    public String toString()
    {
        String res = "Polyline: ";
        res += Arrays.toString(points);
        return res;
    }
}
