package ru.luxtington.main;

import ru.luxtington.oop.generics.Storage;

import java.util.List;

public interface Shortener <T>{
    Storage<T> makeShorter(List<T> objs);
}
