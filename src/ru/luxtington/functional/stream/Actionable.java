package ru.luxtington.functional.stream;

public interface Actionable<T,R> {
     R execute(T element);
}
