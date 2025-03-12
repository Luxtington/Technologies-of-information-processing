package ru.luxtington.oop.different.items.railway;

public class CoupePlace {
    final Location location;
    final int number;

    public CoupePlace(int number, Location location) {
        this.number = number;
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "CoupePlace with "+ location + " location, number = " + number;
    }
}
