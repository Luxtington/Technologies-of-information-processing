package ru.luxtington.oop.different.animals.cats;

public class Cat implements Meowable{
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    public void makeMeow(int times) {
        String res = name + ": ";
        for (int i = 0; i < times; i++) {
            res += "meow";
            if (i == times - 1) res += "!";
            else res += ", ";
        }
        System.out.println(res);
    }

    @Override
    public void makeMeow() {
        makeMeow(1);
    }

    public String toString() {
        return "Cat: " + name;
    }
}
