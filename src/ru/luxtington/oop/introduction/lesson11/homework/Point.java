package ru.luxtington.oop.introduction.lesson11.homework;

public class Point
{
    public double x;
    public double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return "{" + this.x + "; " + this.y +'}';
    }
}
