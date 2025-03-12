package ru.luxtington.oop.different.cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Way {
    public City city;
    private int cost;

    public Way(City city, int cost) {
        this.city = city;
        this.setCost(cost);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 0) throw new IllegalArgumentException("Incorrect value of cost, it should be greater/equal than 0");
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return city == way.city;
    }

    @Override
    public int hashCode() {
        return city.title.hashCode(); //Objects.hashCode(city); = StackOverflow
    }

    public String toString() {
        return city.getTitle() + ": " + cost;
    }
}
