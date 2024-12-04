package ru.luxtington.main;

public interface Actor <O,T>{
    O apply(T obj);
}

//  O - output
// T - input object type
