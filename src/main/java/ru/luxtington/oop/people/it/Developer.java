package ru.luxtington.oop.people.it;

public interface Developer {
    String makeJob();

    default void writeCode() {
        throw new UnsupportedOperationException();
    }
}
