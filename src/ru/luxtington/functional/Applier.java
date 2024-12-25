package ru.luxtington.functional;

public interface Applier<R,T>{
    R apply(T obj);
}

//  R - result
// T - input object type
