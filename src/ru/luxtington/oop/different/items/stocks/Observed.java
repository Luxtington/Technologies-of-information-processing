package ru.luxtington.oop.different.items.stocks;

import org.jetbrains.annotations.NotNull;

public interface Observed {
    void addObserver(@NotNull Observer observer);
    void removeObserver(@NotNull Observer observer);
    void notifyAllObservers();
}
