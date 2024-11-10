package ru.luxtington.oop.different.animals.cats;

public class MeowTester {

    public static void hearMeow(Meowable...objects){
        for (int i=0; i < objects.length; i++)
            objects[i].makeMeow();
    }
}
