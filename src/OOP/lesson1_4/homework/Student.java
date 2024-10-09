package OOP.lesson1_4.homework;

import java.util.Arrays;

public class Student
{
    public String name;
    public int [] marks;

    public Student(String name, int ... marks)
    {
        this.name = name;
        if (marks.length > 0)
            this.marks = marks;
    }

    public double getAverageMark()
    {
        if (marks == null)
            return 0;

        int i, sum = 0;
        for (i=0; i<marks.length; i++)
            sum+=marks[i];

        return sum/(i);
    }

    public String isHeEpcellentStudent()
    {
        if (marks != null)
        {
            for (int i=0; i<marks.length; i++)
            {
                if (marks[i] != 5) return "He isn't an epcellent student";
            }
            return "He is an epcellent student";
        }
        return "There is no information about this student's marks";
    }

    public String toString()
    {
        String res = (marks == null) ? (name + " without marks") : (name + ": " + Arrays.toString(marks));
        return res;
    }
}
