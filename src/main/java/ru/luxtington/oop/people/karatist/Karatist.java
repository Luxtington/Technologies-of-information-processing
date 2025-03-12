package ru.luxtington.oop.people.karatist;

public class Karatist{

    public final String name;

    public Karatist(String name){
        this.name = name;
    }

    public void hitByLeg(){
        System.out.println(name + ": bac!");
    }

    public void hitByHand(){
        System.out.println(name + ": kija!");
    }

    public void hitWhileJump(){
        System.out.println(name + ": vjuh!");
    }

    public String toString(){
        return "I'm karatist " + name;
    }
}
