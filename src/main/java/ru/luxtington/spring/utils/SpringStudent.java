package ru.luxtington.spring.utils;

import ru.luxtington.oop.people.studying.IncorrectMarkException;

import java.util.*;
import java.util.function.Predicate;

public class SpringStudent<T> {

    private String name;
    private List<T> marks;
    private Predicate<T> rule;

    public SpringStudent(String name, Predicate<T> rule, List<T> marks) {
        this.name = name;
        setRule(rule);
        this.setMarks(marks);
    }

    @SafeVarargs
    public SpringStudent(String name, Predicate<T> rule, T... marks) {
        this(name, rule, Arrays.asList(marks));
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(List<T> marks) {
        this.marks = new ArrayList<>();
        this.addMarks(marks);
    }

    public void setRule(Predicate<T> rule) {
        if (rule == null)
            throw new IllegalArgumentException("Rule can't be null");
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public List<T> getMarks() {
        return new ArrayList<T>(marks);
    }

    public void addMarks(List<T> marks) {
        if (marks == null || marks.isEmpty()) {
            this.marks = new ArrayList<>();
            return;
        }

        for (int i = 0; i < marks.size(); i++) {
            this.addMark(marks.get(i));
        }
    }

    public void addMark(T mark) throws IncorrectMarkException {
        if (rule.test(mark)) {
            marks.add(mark);
        } else
            throw new IncorrectMarkException("Incorrect value of student's mark");
    }

    public void removeMark(T mark) {
        if (!(marks.contains(mark)))
            throw new IllegalArgumentException("There's no such mark in student's marks");

        for (int i = marks.size() - 1; i >= 0; i--)
            if (marks.get(i) == mark) {
                marks.remove(i);
                break;
            }

    }

    public String toString() {
        String res = (marks == null) ? (name + " without marks") : (name + ": " + marks.toString());
        return res;
    }

//    @Override
//    public int compareTo(ru.luxtington.oop.people.studying.Student otherStudent) {
//        if ((this.getAverageMark() - otherStudent.getAverageMark()) == 0)
//            return 0;
//        return (this.getAverageMark() > otherStudent.getAverageMark()) ? 1 : -1;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ru.luxtington.oop.people.studying.Student student = (ru.luxtington.oop.people.studying.Student) o;
//        return Objects.equals(name, student.getName()) && getAverageMark() == student.getAverageMark();
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, getAverageMark());
//    }
//    public double getAverageMark() {
//        if (marks == null)
//            return 0;
//
//        int i, sum = 0;
//        for (i = 0; i < marks.size(); i++)
//            sum += marks.get(i);
//
//        return (double)sum / (i);
//    }
//
//    public boolean isHeEpcellentStudent() {
//        return this.getAverageMark() == rule.getUpMark();
//    }
}

