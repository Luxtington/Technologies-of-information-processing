package ru.luxtington.oop.different.animals.birds;

public class Cuckoo extends Bird{

    @Override
    public void sing(){
        for (int i=0; i< (int)(Math.random()*10); i++)
            System.out.println("Que-que");
    }
}
