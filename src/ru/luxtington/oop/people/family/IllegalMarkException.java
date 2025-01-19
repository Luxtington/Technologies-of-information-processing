package ru.luxtington.oop.people.family;

public class IllegalMarkException extends Exception{
    String message;

    public IllegalMarkException(String message) {
        this.message = message;
    }
}
