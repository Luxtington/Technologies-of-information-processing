package ru.luxtington.oop.different.cities;

public class Way {
    private City city;
    private int cost;

    public Way(City city, int cost) {
        this.city = city;
        this.setCost(cost);
    }

    public City getCity() {
        return city;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 0) throw new IllegalArgumentException("Incorrect value of cost, it should be greater/equal than 0");
        this.cost = cost;
    }


    public String toString() {
        return city.getTitle() + ": " + cost;
    }
}
