package ru.luxtington.oop.people.karatist;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Hittable{
    List<Hittable> kicks = new ArrayList<>();

    public Combo(List<Hittable> kicks){
        this.kicks = kicks;
    }

    @Override
    public void execute(Karatist karatist) {
        for (int i=0; i < kicks.size(); i++){
            kicks.get(i).execute(karatist);
        }
    }
}
