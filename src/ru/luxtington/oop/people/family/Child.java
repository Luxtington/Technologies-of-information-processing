package ru.luxtington.oop.people.family;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Child {
    final String name;
    List<Integer> marks;
    private Parent [] parents = new Parent[2];
    private int indexParent = 0;

    public Child(@NotNull String name) {
        this.name = name;
    }

    void addParent(@NotNull Parent parent){
        parents[indexParent++] = parent;
    }

    public void setMarks(List<Integer> marks) throws IllegalMarkException {
        this.marks = new ArrayList<>();
        addMarks(marks);
    }

    public void addMarks(List<Integer> marks) throws IllegalMarkException{
        for (Integer mark : marks){
            if (!isCorrectMark(mark))
                throw new IllegalMarkException("Incorrect mark");
            this.marks.add(mark);
            if (mark == 2)
                notifyParents(mark);
        }
    }

    private void notifyParents(int mark){
        if (indexParent == 0){
            System.out.println(name + " haven't parents, that's why there will not reactions on marks");
            return;
        }
        for (Parent p : parents){
            if (p == null)
                break;
            p.reactOnMark(mark, this);
        }

    }

    private boolean isCorrectMark(int mark){
        return (mark >= 2 && mark <= 5);
    }

    public String getName() {
        return name;
    }

    public List<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    @Override
    public String toString() {
        return "Child " + name + ", marks: " + marks;
    }
}
