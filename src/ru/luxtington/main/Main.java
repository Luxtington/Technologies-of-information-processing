package ru.luxtington.main;

import ru.luxtington.oop.patterns.behaviour.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Karatist k1 = new Karatist("Daniel");

        Hittable hit1 = new HitByLeg(k1);
        Hittable hit2 = new HitByHand(k1);
        Hittable hit3 = new HitWhileJump(k1);

        Brain brain = new Brain(new ArrayList(Arrays.asList(hit1, hit2, hit3)));
        Brain brain2 = new Brain(new ArrayList(Arrays.asList(hit3, hit1, hit2)));

        brain.executeCombo();
        System.out.println("---------");
        brain2.executeCombo();
    }
}
