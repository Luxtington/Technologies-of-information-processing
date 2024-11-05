package oop.peopleWithTheirItems;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        List<Integer> marks = new ArrayList<Integer>();
        marks.add(2);
        marks.add(5);
        marks.add(3);
        Student s1 = new Student("Petya", marks);
        marks.add(1);

        s1.getMarks().set(0, 1);
        System.out.println(s1);

        //s1.addMark(1);


    }
}
