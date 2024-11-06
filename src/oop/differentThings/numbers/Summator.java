package oop.differentThings.numbers;

import oop.geometricShapes.Figure;
import oop.geometricShapes.HasLengthImpl;

public class Summator {

    public static double summ(Summable...numbers){
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

    public static int summLength(HasLengthImpl... objs){
        int res = 0;

        for (int i=0; i < objs.length; i++)
            res += objs[i].length();

        return res;
    }
}
