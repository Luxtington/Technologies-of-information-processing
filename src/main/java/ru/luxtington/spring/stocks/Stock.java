package ru.luxtington.spring.stocks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Stock implements Observed {

    final String title;
    int cost;

    List<Observer> subscribers = new ArrayList<>();

    public Stock(int cost, String title) {
        setCost(cost);
        this.title = title;
    }

    @Override
    public void addObserver(@NotNull Observer observer) {
        observer.addStock(this);
        subscribers.add(observer);
    }

    @Override
    public void removeObserver(@NotNull Observer observer) {
        if (!(subscribers.contains(observer)))
            throw new NoSuchElementException("No such observer");
        observer.removeStock(this);
        subscribers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o : subscribers)
            o.reactOnAction(this);
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost < 0)
            throw new IllegalArgumentException("Cost can't be less than 0");
        this.cost = cost;
        notifyAllObservers();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Stock stock)) return false;
        return cost == stock.cost && Objects.equals(title, stock.title) && Objects.equals(subscribers, stock.subscribers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, cost, subscribers);
    }
}
