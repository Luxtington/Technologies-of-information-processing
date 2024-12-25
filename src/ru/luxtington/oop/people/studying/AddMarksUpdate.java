package ru.luxtington.oop.people.studying;

import java.util.List;

public class AddMarksUpdate implements Update{

    private List<Integer> marks;
    private Student student;

    public AddMarksUpdate(List<Integer> marks, Student student) {
        this.marks = marks;
        this.student = student;
    }

    @Override
    public void rollBack() {
        for (int i = marks.size() - 1; i >= 0; i--)
            student.removeMark(marks.get(i));
    }
}
