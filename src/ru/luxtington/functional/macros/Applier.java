package ru.luxtington.functional.macros;

public interface Applier<T,R>{
    R apply(T element);
}
