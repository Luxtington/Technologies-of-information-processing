package OOP.peoplesWithTheirItems;

import java.util.List;
import java.util.ArrayList;

public class Student
{
    private final String name;
    private List<Integer> marks;

    public Student(String name, List<Integer> marks)
    {
        this.name = name;
        for (int i=0; i<marks.size(); i++)
        {
            if (!(isCorrectMark(marks.get(i))))
                throw new IllegalArgumentException("Incorrect value of student's mark");
        }
        this.marks = marks;
    }

    public double getAverageMark()
    {
        if (marks == null)
            return 0;

        int i, sum = 0;
        for (i=0; i<marks.size(); i++)
            sum += marks.get(i);

        return sum/(i);
    }

    public boolean isHeEpcellentStudent()
    {
        return this.getAverageMark() == 5;
    }

    public String getName()
    {
        return name;
    }

    public List<Integer> getMarks()
    {
        List<Integer> copyMarks = new ArrayList<Integer>();
        for (int i=0; i < marks.size(); i++)
            copyMarks.add(marks.get(i));
        return copyMarks;
    }

    public void addMark(int mark)
    {
        if (isCorrectMark(mark))
            marks.add(mark);
        else
            throw new IllegalArgumentException("Incorrect value of student's mark");
    }

    private boolean isCorrectMark(int mark)
    {
        return (mark >= 2 && mark <= 5);
    }

    public String toString()
    {
        String res = (marks == null) ? (name + " without marks") : (name + ": " + marks.toString());
        return res;
    }
}
