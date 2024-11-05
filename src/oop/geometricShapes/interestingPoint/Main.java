package oop.geometricShapes.interestingPoint;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Attribute a1 = new Size(10), a2 = new Color("red"), a3 = new Y(10), a4 = new Time(11, 35);
        PointUniversal p1 = new PointUniversal(5, new ArrayList<>(Arrays.asList(a1, a2, a4)));

        Attribute a5 = new Size(10), a6 = new Color("pink");

        p1.addAttribute(a3);
        //p1.addAttribute(a4);  //should be exc
        //p1.removeAttribute(a5); //should be exc
        System.out.println(p1);

        Attribute delA = new Color("red");
        p1.removeAttribute(delA);
        System.out.println(p1);

    }
}
