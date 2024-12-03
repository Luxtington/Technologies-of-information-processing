package ru.luxtington.oop.generics;

import java.util.ArrayList;
import java.util.List;

public class Stack <T>{
    private List<T> arr = new ArrayList<>();

    public Stack(T root){
        push(root);
    }

    public void push(T element){
        arr.add(element);
    }

    public T pop(){
        T tmp = arr.get(arr.size()-1);
        arr.remove(arr.size()-1);
        return tmp;
    }

    public T peek(){
        return arr.get(arr.size()-1);
    }

    public String toString(){

        StringBuilder res = new StringBuilder();

        for (int i = arr.size()-1; i >= 0; i--)
            res.append(arr.get(i) + " ");

        return res.toString();
    }
}
