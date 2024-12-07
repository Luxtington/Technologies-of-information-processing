package ru.luxtington.main;

public interface Reducer<R,T>{ // like BiConsumer but WITHOUT void, cause of Int, Str
    R reduce(R val, T elem);
}
