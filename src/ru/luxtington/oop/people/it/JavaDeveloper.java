package ru.luxtington.oop.people.it;

public class JavaDeveloper implements Developer{
    @Override
    public String makeJob() {
        return "Java dev writes java code";
    }

    @Override
    public String toString() {
        return "JavaDeveloper";
    }
}
