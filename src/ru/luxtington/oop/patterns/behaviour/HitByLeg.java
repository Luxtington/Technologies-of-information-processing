package ru.luxtington.oop.patterns.behaviour;

public class HitByLeg implements Hittable{

    @Override
    public void execute(Karatist karatist){
        karatist.hitByLeg();
    }
}
