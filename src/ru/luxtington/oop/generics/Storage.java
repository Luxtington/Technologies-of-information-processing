package ru.luxtington.oop.generics;

public final class Storage <T>{

    private final T item;
    private final T alternativeItem;

    public Storage(T item, T alternativeItem){
        this.item = item;
        this.alternativeItem = alternativeItem;
    }

    public T getItem(){
        if (item == null)
            return alternativeItem;
        return item;
    }

    public String toString() {
        return "Storage: " + "item=" + item;
    }
}
