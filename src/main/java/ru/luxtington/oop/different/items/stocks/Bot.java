package ru.luxtington.oop.different.items.stocks;

import org.jetbrains.annotations.NotNull;

public class Bot implements Observer{

    @Override
    public void reactOnAction(@NotNull Stock stock) {
        if (stock.cost < 70)
            System.out.println("U should by " + stock.title + " for " + stock.cost + "$");
    }
}
