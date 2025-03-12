package ru.luxtington.oop.people.studying;

public class Rule2To5 extends Rule{

    private int lowMark = 2;
    private int upMark = 5;

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
