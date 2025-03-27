package ru.luxtington.spring.stocks;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Printer implements Observer {

    private List<Stock> allStocks = new ArrayList<>();

    public Printer(Stock... stocks) {
        for (Stock s : stocks)
            addStock(s);
    }

    @Override
    public void reactOnAction(Stock stock) {
        System.out.println("Printer detects: stock " + stock.title + ": " + stock.cost + "$");
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
