package ru.luxtington.functional.stream;

public interface Reductor<T>{ // like BiConsumer but WITHOUT void, cause of Int, Str
    T reduce(T val1, T val2);
}
