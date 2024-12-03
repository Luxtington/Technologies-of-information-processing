package ru.luxtington.oop.patterns.behaviour;

public class HitWhileJump implements Hittable{

    @Override
    public void execute(Karatist karatist){
        karatist.hitWhileJump();
    }
}
