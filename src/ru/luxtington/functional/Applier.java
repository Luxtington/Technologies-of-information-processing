package ru.luxtington.functional;

public interface Applier<O,T>{
    O apply(T obj);
}

//  O - output
// T - input object type
