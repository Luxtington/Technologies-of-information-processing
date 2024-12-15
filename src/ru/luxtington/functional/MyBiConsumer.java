package ru.luxtington.functional;

public interface MyBiConsumer<R, T> { // exactly copy of BiConsumer
    void accept(R collection, T elem);
}
