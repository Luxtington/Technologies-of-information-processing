package oop.basicLessons.lesson1_3.homework;

import java.util.Arrays;

public class Student
{
    public String name;
    public int [] marks;

    public Student(String name, int [] marks)
    {
        this.name = name;
        this.marks = marks;
    }

    public Student(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return name + ": " + Arrays.toString(marks);
    }
}
