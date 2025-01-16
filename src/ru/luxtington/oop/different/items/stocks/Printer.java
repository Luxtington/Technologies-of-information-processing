package ru.luxtington.oop.different.items.stocks;

import org.jetbrains.annotations.NotNull;

public class Printer implements Observer{

    @Override
    public void reactOnAction(@NotNull Stock stock) {
        System.out.println("Stock " + stock.title + ": " + stock.cost + "$");
    }
}
