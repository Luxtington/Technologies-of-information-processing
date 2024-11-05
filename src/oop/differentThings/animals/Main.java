package oop.differentThings.animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bird s1 = new Sparrow();
        Bird c1 = new Cuckoo();
        Bird p1 = new Parrot("qwerty");

        List<Bird> birds = new ArrayList<>(Arrays.asList(s1, c1, p1));

        for (int i=0; i < birds.size(); i++)
            birds.get(i).sing();

    }
}
