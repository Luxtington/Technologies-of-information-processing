package ru.luxtington.oop.geometry.points.interestingPoint;

public class Size extends Attribute{

    public Size(int value){
        super("Size", (Integer)value);
    }

    public Integer getValue(){
        return (Integer)super.getValue();
    }
}
