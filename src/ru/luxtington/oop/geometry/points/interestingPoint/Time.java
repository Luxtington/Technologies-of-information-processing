package ru.luxtington.oop.geometry.points.interestingPoint;

public class Time extends Attribute{

    public Time(int hours, int minutes){
        super("Time", hours + ":" + minutes);
    }

    public String getValue(){
        return (String)super.getValue();
    }
}
