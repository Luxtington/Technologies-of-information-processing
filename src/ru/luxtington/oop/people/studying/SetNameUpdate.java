package ru.luxtington.oop.people.studying;

public class SetNameUpdate implements Update{

    private String oldName;
    private String newName;
    Student student;

    public SetNameUpdate(Student student, String newName) {
        this.oldName = student.getName();
        this.newName = newName;
    }

    @Override
    public void rollBack() {
        student.setName(oldName);
    }
}
