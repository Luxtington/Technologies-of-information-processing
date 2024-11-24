package ru.luxtington.oop.patterns.behaviour;

import java.util.ArrayList;
import java.util.List;

public class Brain{

    List<Hittable> combination = new ArrayList<>();


    public Brain(List<Hittable> combination){
        this.combination = combination;
    }

    public void executeCombo(){
        for (int i=0; i < combination.size(); i++){
            combination.get(i).execute();
        }
    }
}
