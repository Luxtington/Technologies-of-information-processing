package ru.luxtington.oop.different.items.railway;

import org.jetbrains.annotations.NotNull;

public enum Location {
    LOW_PLACE("Low"),
    UP_PLACE("Up");

    private String location;

    Location(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return location + "";
    }
}
