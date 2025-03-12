package ru.luxtington.oop.different.animals.dogs;

import ru.luxtington.oop.different.animals.cats.Meowable;

public class Dog implements Barkable {
    private  String name;

    public Dog(String name) {
        this.name = name;
    }

    public void bark(int times){
        StringBuilder res = new StringBuilder(name + ": ");
        for (int i=0; i < times; i++)
            res.append("Gav! ");
        System.out.println(res);
    }

    @Override
    public void bark(){
        bark(1);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return "Dog: " + name;
    }
}
