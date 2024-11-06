package oop.differentThings.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Bird s1 = new Sparrow();
        Bird c1 = new Cuckoo();
        Bird p1 = new Parrot("qwerty");

        Bird [] birds = {s1, c1, p1};
        BirdMarket.hearSongs(birds);*/

        Meowable [] objs = {new Cat("Barsik"), new Bot("Anton")};
        MeowTester.hearMeow(objs);

    }
}
