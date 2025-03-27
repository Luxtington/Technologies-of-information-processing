package ru.luxtington.spring.stocks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Bot implements Observer {

    private List<Stock> allStocks = new ArrayList<>();

    public Bot(Stock... stocks) {
        for (Stock s : stocks)
            addStock(s);
    }

    @Override
    public void reactOnAction(Stock stock) {
        if (stock.cost < 70)
            System.out.println("!!! Bot: u should buy " + stock.title + " for " + stock.cost + "$");
    }

    @Override
    public void addStock(Stock stock) {
        this.allStocks.add(stock);
    }

    @Override
    public void removeStock(Stock stock) {
        if (allStocks.contains(stock))
            allStocks.remove(stock);
    }
}
