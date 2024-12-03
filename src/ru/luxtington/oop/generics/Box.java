package ru.luxtington.oop.generics;

public class Box <T>{

    private T item;

    public Box(T item){
        this.item = item;
    }

    public boolean isEmpty(){
        return (item == null);
    }

    public T popItem(){
        T tmp = item;
        item = null;
        return tmp;
    }

    public void pushItem(T item){
        if (!(this.isEmpty()))
            throw new RuntimeException("Box already has item");
        this.item = item;
    }

    public String toString(){
        return "Box has " + item;
    }
}
