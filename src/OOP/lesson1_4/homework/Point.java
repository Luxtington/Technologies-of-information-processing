package OOP.lesson1_4.homework;

public class Point
{
    public int x;
    public  int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
