package ru.luxtington.oop.different.items.railway;

import org.jetbrains.annotations.NotNull;

public class Customer {
    final String name;
    final Gender gender;

    public Customer(@NotNull String name, @NotNull Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Customer's name - " + name + ", gender = " + gender;
    }
}
