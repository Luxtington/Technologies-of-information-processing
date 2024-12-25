package ru.luxtington.functional;

public interface Actionable<T,R> {
     R execute(T element);
}
