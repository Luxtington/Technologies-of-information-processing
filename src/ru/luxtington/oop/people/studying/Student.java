package ru.luxtington.oop.people.studying;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Student {
    private final String name;
    private List<Integer> marks;
    private Rule rule;

    public Student(String name, Rule rule, List<Integer> marks) {
        this.name = name;
        setRule(rule);
        this.setMarks(marks);
    }

    public Student(String name, Rule rule, Integer... marks) {
        this(name, rule, Arrays.asList(marks));
    }

    public void setMarks(List<Integer> marks) {
        this.marks = new ArrayList<>();
        this.addMarks(marks);
    }

    public void setRule(Rule rule) {
        if (rule == null)
            throw new IllegalArgumentException("Rule can't be null");
        this.rule = rule;
    }

    public double getAverageMark() {
        if (marks == null)
            return 0;

        int i, sum = 0;
        for (i = 0; i < marks.size(); i++)
            sum += marks.get(i);

        return sum / (i);
    }

    public boolean isHeEpcellentStudent() {
        return this.getAverageMark() == rule.getUpMark();
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<Integer>(marks);
    }

    public void addMarks(List<Integer> marks) {
        for (int i = 0; i < marks.size(); i++)
            this.addMark(marks.get(i));
    }

    public void addMark(int mark) throws IncorrectMarkException {
        if (rule.isCorrectMark(mark))
            marks.add(mark);
        else
            throw new IncorrectMarkException("Incorrect value of student's mark");
    }

    public void removeMark(int mark){
        if (!(marks.contains(mark)))
            throw new IllegalArgumentException("There's no such mark in student's marks");
        for (int i=0; i < marks.size(); i++)
            if (marks.get(i) == mark)
                marks.remove(i);
        //marks.remove(mark);
    }

    public String toString() {
        String res = (marks == null) ? (name + " without marks") : (name + ": " + marks.toString());
        return res;
    }
}
