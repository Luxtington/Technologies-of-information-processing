package ru.luxtington.oop.geometry.figures;

import java.util.ArrayList;
import java.util.List;

public class GroupOfMoveable implements Moveable{

    private List<Moveable> objects = new ArrayList<>();

    public GroupOfMoveable(Moveable...objects) {
        this.objects = List.of(objects);
    }

    @Override
    public void moveFigure(Axis axis, int step) {
        for (Moveable m : objects) {
            m.moveFigure(axis, step);
        }
    }

    public String toString(){
        StringBuilder res = new StringBuilder("Group with objects:" + System.lineSeparator());

        for (Moveable m : objects)
            res.append(m + ";" + System.lineSeparator());

        return res.toString();
    }
}
