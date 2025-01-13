package ru.luxtington.oop.different.animals.cats;

public class Cat implements Meowable{
    public String name;

    public Cat(String name) {
        this.name = name;
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

    public String toString() {
        return "Cat: " + name;
    }
}
