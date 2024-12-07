package ru.luxtington.main;

public interface MyBiConsumer<R, T> { // exactly copy of BiConsumer
    void accept(R val, T elem);
}
