package ru.luxtington.oop.different.items.traffic;

public class TrafficLight {

    private Color currColor;

    public TrafficLight() {
        this.currColor =  YellowAfterRedColor.createYellowAfterRedColor();
    }

    public void next(){
        currColor = currColor.switchToNext();
        currColor.shine();
    }

    public String toString(){
        return "Traffic light № " + hashCode();
    }
}
