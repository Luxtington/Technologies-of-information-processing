package ru.luxtington.oop.different.animals.cats;

import ru.luxtington.reflection.base.other.Entity;

public class Cat extends Entity implements Meowable{
    public String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void makeMeow(int times) {
        StringBuilder res = new StringBuilder(name + ": ");

        for (int i = 0; i < times; i++)
            res.append("Meow ");

        System.out.println(res);
    }

    @Override
    public void makeMeow() {
        makeMeow(1);
    }

    public String getName() {
        return name;
    }
}
