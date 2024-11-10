package ru.luxtington.oop.different.numbers;

import ru.luxtington.oop.geometry.figures.Figure;
import ru.luxtington.oop.geometry.figures.Lengthable;

public class Summator {

    public static double summ(Number...numbers){
        double summ = 0;

        for (int i=0; i < numbers.length; i++)
            summ += numbers[i].doubleValue();

        return summ;
    }

    public static double summAreas(Figure...figures){
        double res = 0;

        for (int i=0; i < figures.length; i++)
            res += figures[i].area();

        return res;
    }

    public static int summLength(Lengthable... objs){
        int res = 0;

        for (int i=0; i < objs.length; i++)
            res += objs[i].length();

        return res;
    }
}
