package OOP.lesson3.homework;

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
        for (int i=0; i<points.length; i++)
        {
            res+=points[i];

            if (i < points.length-1)
                res+=", ";
        }
        return res;
    }
}
