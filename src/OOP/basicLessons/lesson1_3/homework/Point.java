package OOP.basicLessons.lesson1_3.homework;

public class Point
{
    public int x;
    public int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void updateCoords(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "{" + this.x + "; " + this.y +'}';
    }
}
