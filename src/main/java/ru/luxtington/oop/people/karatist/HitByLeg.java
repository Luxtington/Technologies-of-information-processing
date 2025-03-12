package ru.luxtington.oop.people.karatist;

public class HitByLeg implements Hittable{

    @Override
    public void execute(Karatist karatist){
        karatist.hitByLeg();
    }
}
