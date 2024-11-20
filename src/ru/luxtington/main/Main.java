package ru.luxtington.main;

import ru.luxtington.oop.different.cities.City;
import ru.luxtington.oop.different.cities.SmartCity;
import ru.luxtington.oop.different.cities.Way;
import ru.luxtington.oop.different.numbers.Fraction;
import ru.luxtington.oop.geometry.figures.ClosedLine;
import ru.luxtington.oop.geometry.figures.Line;
import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point3D;
import ru.luxtington.oop.people.studying.Rule2To5;
import ru.luxtington.oop.people.studying.Student;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Fraction f1 = new Fraction(3,4);
        Fraction f2 = f1.clone();
        //System.out.println(f2 == f1);

        Point3D p1 = new Point3D(1,2,3);
        Point3D p2 = (Point3D) p1.clone();
        System.out.println(p2 == p1);
        //System.out.println(p2);

        Line l1 = new Line(new Point2D(1,2), new Point2D(3,4));
        Line l2 = l1.clone();

        l2.setBeginPoint(new Point2D(99, 99));
        System.out.println(l1 + " | " + l2);


        /*City cityB = new City("B"), cityC = new City("C"), cityD = new City("D"), cityE = new City("E");

        City cityF = new City("F", new ArrayList<>(Arrays.asList(new Way(cityB,1), new Way(cityC, 2), new Way(cityD,3))));
        SmartCity cityA = new SmartCity("A", new ArrayList<>(Arrays.asList(new Way(cityB,2), new Way(cityC, 1), new Way(cityD,3))));
        System.out.println(cityE.equals(cityD) + "| hash1: " + cityE.hashCode() + ", hash2: " + cityD.hashCode());
        System.out.println(cityF.equals(cityA) + "| hash1: " + cityF.hashCode() + ", hash2: " + cityA.hashCode());
        System.out.println(cityA.equals(cityF) + "| hash1: " + cityA.hashCode() + ", hash2: " + cityF.hashCode());
        System.out.println(cityB.equals(cityC) + "| hash1: " + cityB.hashCode() + ", hash2: " + cityC.hashCode());

        Way test1 = new Way(new City("BB"), 1), test2 = new Way(new City("BB"), 1);
        System.out.println("Test of ways's equals: " + test1.equals(test2));


        City AA = new City("AA");
        City BB = new City("BB");
        City CC = new City("CC");
        City DD = new City("DD");

        AA.addWay(new Way(CC,2));
        AA.addWay(new Way(DD,4));

        BB.addWay(new Way(DD,5));
        BB.addWay(new Way(CC,3));
        System.out.println("ST test = " + AA.equals(BB));
        System.out.println(AA.hashCode() == BB.hashCode());*/

    }
}
