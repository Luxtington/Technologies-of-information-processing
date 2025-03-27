package ru.luxtington.spring.stocks;

public interface Observer {
    void reactOnAction(Stock stock);
    void addStock(Stock stock);
    void removeStock(Stock stock);
}
