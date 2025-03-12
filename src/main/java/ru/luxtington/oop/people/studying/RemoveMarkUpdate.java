package ru.luxtington.oop.people.studying;

public class RemoveMarkUpdate implements Update{
    private Integer mark;
    Student student;

    public RemoveMarkUpdate(Student student, Integer mark) {
        this.mark = mark;
        this.student = student;
    }

    @Override
    public void rollBack() {
        student.removeMark(mark);
    }
}
