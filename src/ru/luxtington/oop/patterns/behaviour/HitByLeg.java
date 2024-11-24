package ru.luxtington.oop.patterns.behaviour;

public class HitByLeg implements Hittable{

    Karatist karatist;

    public HitByLeg(Karatist karatist){
        this.karatist = karatist;
    }

    @Override
    public void execute(){
        karatist.hitByLeg();
    }
}
