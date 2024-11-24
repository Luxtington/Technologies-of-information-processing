package ru.luxtington.oop.patterns.behaviour;

public class HitWhileJump implements Hittable{

    Karatist karatist;

    public HitWhileJump(Karatist karatist){
        this.karatist = karatist;
    }

    @Override
    public void execute(){
        karatist.hitWhileJump();
    }
}
