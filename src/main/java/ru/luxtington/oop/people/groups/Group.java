package ru.luxtington.oop.people.groups;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Group implements Iterable<Integer>{
    final String title;
    final int yearOfFounding;
    int number;
    private List<Student> students = new ArrayList<>();

    public Group(String title, int yearOfFounding, int number) {
        this.title = title;
        this.yearOfFounding = yearOfFounding;
        this.number = number;
    }

    public void addStudent(@NotNull Student student){
        if (student.group != null){
            student.group.removeStudent(student);
            return;
        }
        student.group = this;
        students.add(student);
    }

    public void removeStudent(@NotNull Student student){
        if (!(this.students.contains(student)))
            throw new NoSuchElementException("This student don't study there");
        students.remove(student);
        student.group = null;
    }

    @Override
    public @NotNull Iterator<Integer> iterator() {
        return new GroupIterator();
    }

    private class GroupIterator implements Iterator<Integer>{

        private int index = 0;
        List<Integer> allMarks = getAllMarks();

        private List<Integer> getAllMarks(){
            List<Integer> allMarks = new ArrayList<>();
            for (Student s : students)
                allMarks.addAll(s.marks);
            return allMarks;
        }

        @Override
        public boolean hasNext() {
            return index < allMarks.size();
        }

        @Override
        public Integer next() {
            index++;
            return allMarks.get(index-1);
        }
    }

    public int getYearOfFounding() {
        return yearOfFounding;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Group " + title + "-" + number + ": ");
        for (Student s : students)
            res.append(s + ", ");
        res.append(" - " + students.size());
        return res.toString();
    }
}
