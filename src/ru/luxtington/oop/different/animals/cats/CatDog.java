package ru.luxtington.oop.different.animals.cats;

import ru.luxtington.oop.different.animals.dogs.Barkable;
import ru.luxtington.oop.different.animals.dogs.Dog;

public class CatDog implements Meowbarkable {

    private Meowable cat;
    private Barkable dog;

    public CatDog(Meowable cat, Barkable dog) {
        this.cat = cat;
        this.dog = dog;
    }

    @Override
    public void makeMeow() {
        cat.makeMeow();
    }

    @Override
    public void bark() {
        dog.bark();
    }

    public String toString(){
        Cat tmpCat = (Cat)cat;
        Dog tmpDog = (Dog)dog;

        return "Cat&Dog: " + tmpCat.getName() + tmpDog.getName(); }
}
