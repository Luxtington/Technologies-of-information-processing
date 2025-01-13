package ru.luxtington.oop.people.karatist;

public class Brain{

    Combo combination;


    public Brain(Combo combination){
        this.combination = combination;
    }

    public void executeCombo(Karatist karatist){
        for (int i=0; i < combination.kicks.size(); i++){
            combination.kicks.get(i).execute(karatist);
        }
    }
}
