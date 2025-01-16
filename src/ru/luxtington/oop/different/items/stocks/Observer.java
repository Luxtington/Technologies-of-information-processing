package ru.luxtington.oop.different.items.stocks;

import org.jetbrains.annotations.NotNull;

public interface Observer {
    void reactOnAction(@NotNull Stock stock);
}
