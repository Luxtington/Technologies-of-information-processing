package ru.luxtington.oop.people.groups;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Student {
    final String name;
    List<Integer> marks = new ArrayList<>();
    Group group;

    public Student(@NotNull String name, List<Integer> marks, @NotNull Group group) {
        this.name = name;
        this.marks = marks;
        setGroup(group);
    }

    public void setGroup(Group group) {
        if (group == null && this.group != null){
            this.group.removeStudent(this);
            return;
        }

        else if (group != null && this.group != null){
            this.group.removeStudent(this);
            group.addStudent(this);
            return;
        }
        else if (group != null){
            group.addStudent(this);
            return;
        }
        this.group = group;
    }

    public void addMarks(Integer... marks){
        for (int i=0; i < marks.length; i++){
            if (marks[i] > 1 && marks[i] < 6)
                this.marks.add(marks[i]);
        }
    }

    @Override
    public String toString() {
        return "Student " + name + ", marks = " + marks;
    }
}
