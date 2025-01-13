package ru.luxtington.oop.generics;

import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public final class Storage <T>{

    private T item;
    private Supplier<T> itemSupplier;

    private static final Storage <?> EMPTY_STORAGE = new Storage<>(null);

    private Storage(Supplier<T> itemSupplier){
        this.itemSupplier = itemSupplier;
    }

    public static Storage <?> emptyStorage(){
        return EMPTY_STORAGE;
    }

    public static <T> Storage<T> of(Supplier<T> itemSupplier){
        if (itemSupplier == null){
            return (Storage<T>)EMPTY_STORAGE;
        }
        return new Storage<T>(itemSupplier);
    }

    public T getItem(T alternativeItem){
        if (itemSupplier == null)
            return alternativeItem;
        this.item = itemSupplier.get();
        return (item == null) ? alternativeItem : item;
    }

    public String toString() {
        return "Storage: " + "item=" + item;
    }
}
