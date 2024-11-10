package ru.luxtington.oop.people.studying;

public class Rule10To13 extends Rule {
    private int lowMark = 10;
    private int upMark = 13;

    @Override
    public int getUpMark(){
        return upMark;
    }

    @Override
    public int getLowMark(){
        return lowMark;
    }

    @Override
    public boolean isCorrectMark(int mark){
        return (mark >= lowMark && mark <= upMark);
    }
}
