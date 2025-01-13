package ru.luxtington.oop.people.karatist;

public class HitWhileJump implements Hittable{

    @Override
    public void execute(Karatist karatist){
        karatist.hitWhileJump();
    }
}
