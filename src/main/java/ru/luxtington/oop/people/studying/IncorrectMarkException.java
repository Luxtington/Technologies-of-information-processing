package ru.luxtington.oop.people.studying;

public class IncorrectMarkException extends RuntimeException{

    private String message;

    public IncorrectMarkException(String message){
        this.message = message;
    }
}
