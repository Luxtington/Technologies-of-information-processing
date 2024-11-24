package ru.luxtington.oop.patterns.behaviour;

public class HitByHand implements Hittable{

    Karatist karatist;

    public HitByHand(Karatist karatist){
        this.karatist = karatist;
    }

    @Override
    public void execute(){
        karatist.hitByHand();
    }
}
