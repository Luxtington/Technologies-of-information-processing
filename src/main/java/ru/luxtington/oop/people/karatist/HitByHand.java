package ru.luxtington.oop.people.karatist;

public class HitByHand implements Hittable{

    private static final HitByHand kick = new HitByHand();

    private HitByHand() {
    }

    public static HitByHand createHitByHand(){
        return kick;
    }

    @Override
    public void execute(Karatist karatist){
        karatist.hitByHand();
    }
}
