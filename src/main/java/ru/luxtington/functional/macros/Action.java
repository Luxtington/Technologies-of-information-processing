package ru.luxtington.functional.macros;

public interface Action<T,R>{
    R execute(T elem);
}
