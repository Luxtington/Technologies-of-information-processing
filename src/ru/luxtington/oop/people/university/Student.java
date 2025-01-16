package ru.luxtington.oop.people.university;

public final class Student extends Person{
    final String name;
    final int numberStudentCard;

    public Student(String name, int numberStudentCard) {
        this.name = name;
        this.numberStudentCard = numberStudentCard;
    }

    @Override
    public boolean canIGo() {
        String tmpName = name == null ? "" : name;
        return (!tmpName.isBlank() && (numberStudentCard > 0 && numberStudentCard < 1_000_000));
    }

    public String getName() {
        return name;
    }

    public int getNumberStudentCard() {
        return numberStudentCard;
    }

    @Override
    public String toString() {
        return "Student: " + name + ", " + numberStudentCard;
    }
}
