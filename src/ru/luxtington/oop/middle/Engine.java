package ru.luxtington.oop.middle;

public class Engine {
    private String typeEngine;
    private int mileage;

    public Engine(String typeEngine, int mileage){
        if (typeEngine.isBlank())
            throw new IllegalArgumentException("Incorrect engine's type");
        this.typeEngine = typeEngine;

        if (mileage < 0)
            throw new IllegalArgumentException("Mileage can't be less than 1 kilometer");
        this.mileage = mileage;
    }

    public int getMileage(){
        return mileage;
    }

    public void addMileage(int mileage){
        if (mileage < 0)
            throw new IllegalArgumentException("Mileage can't be 0");
        this.mileage = mileage;
    }

    public String toString(){
        return "Engine " + typeEngine + ", mileage = " + mileage + " km";
    }
}
