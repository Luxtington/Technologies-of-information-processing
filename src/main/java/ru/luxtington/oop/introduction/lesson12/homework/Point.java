package ru.luxtington.oop.introduction.lesson12.homework;

public class Point
{
    public int x;
    public int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void updatePointCoords(int newX, int newY)
    {
        x = newX;
        y = newY;
    }

    public String toString()
    {
        return "{" + x + "; " + y + "}";
    }

}
