package ru.luxtington.oop.people.family;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Parent implements Reactable{
    final String name;
    List<Child> children = new ArrayList<>();
    private Swearing mood;

    public Parent(String name, @NotNull Swearing mood) {
        this.name = name;
        setMood(mood);
    }

    @Override
    public void reactOnMark(int mark, Child child) {
        mood.swear(mark, child);
    }

    public void addChild(@NotNull Child child){
        children.add(child);
        child.addParent(this);
    }

    public void setMood(@NotNull Swearing mood){
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Parent - " + name;
    }
}
