package ru.luxtington.oop.different.animals.dogs;

import ru.luxtington.oop.different.animals.cats.Meowable;

public class DogAdapter implements Meowable {

    private Dog dog;

    public DogAdapter(Dog dog) {
        this.dog = dog;
    }

    @Override
    public void makeMeow() {
        dog.bark();
    }
}
