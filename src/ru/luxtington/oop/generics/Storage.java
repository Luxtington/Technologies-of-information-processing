package ru.luxtington.oop.generics;

public final class Storage <T>{

    private final T item;
    private static final Storage <?> EMPTY_STORAGE = new Storage<>(null);

    private Storage(T item){
        this.item = item;
    }

    public static Storage <?> emptyStorage(){
        return EMPTY_STORAGE;
    }

    public static <T> Storage<T> of(T value){
        if (value == null){
            return (Storage<T>)EMPTY_STORAGE;
        }
        return new Storage<T>(value);
    }

    public T getItem(T alternativeItem){
        if (item == null)
            return alternativeItem;
        return item;
    }

    public String toString() {
        return "Storage: " + "item=" + item;
    }
}
