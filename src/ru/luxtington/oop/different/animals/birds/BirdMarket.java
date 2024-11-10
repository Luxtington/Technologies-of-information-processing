package ru.luxtington.oop.different.animals.birds;

public class BirdMarket {

    public static void hearSongs(Bird...birds){
        for (int i=0; i < birds.length; i++)
            birds[i].sing();
    }
}
