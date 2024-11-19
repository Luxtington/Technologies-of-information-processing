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

        /*Fraction f1 = new Fraction(3,4);
        Fraction f2 = new Fraction(3,4);
        Fraction f3 = f2.clone();
        System.out.println(f1.equals(f2));
        System.out.println(f3 == f2);


        Point3D p111 = new Point3D(4,5,6);
        Point3D p222 = new Point3D(4,5,6);
        System.out.println(p111.equals(p222));

        Line l1 = new Line(new Point2D(1,2), new Point2D(1,4));
        Line l2 = new Line(new Point2D(7,8), new Point2D(1,2));
        System.out.println(l1.equals(l2));

        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());

        Point2D p1 = new Point2D(1,2), p2 = new Point2D(3,4), p3 = new Point2D(5,6);

        Polyline pl1 = new Polyline(new ArrayList<>(Arrays.asList(p1, p2, p3)));
        Polyline pl2 = new Polyline(new ArrayList<>(Arrays.asList(p1, p3, p2, p1)));
        Polyline pl3 = new Polyline(new ArrayList<>(Arrays.asList(p3, p2, p1)));
        ClosedLine cl1 = new ClosedLine(new ArrayList<>(Arrays.asList(p1, p2, p3)));

        System.out.println(pl1.equals(pl2) + "| hash1: " + pl1.hashCode() + ", hash2: " + pl2.hashCode());
        System.out.println(pl1.equals(pl3) + "| hash1: " + pl1.hashCode() + ", hash2: " + pl3.hashCode());
        System.out.println(pl2.equals(cl1) + "| hash1: " + pl2.hashCode() + ", hash2: " + cl1.hashCode());
        System.out.println(cl1.equals(pl2) + "| hash1: " + cl1.hashCode() + ", hash2: " + pl2.hashCode());


        City cityB = new City("B"), cityC = new City("C"), cityD = new City("D"), cityE = new City("E");

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
        AA.addWay(new Way(CC,2));
        BB.addWay(new Way(CC,3));
        System.out.println("ST test = " + AA.equals(BB));

        Student s1 = new Student("Vasya", new Rule2To5(), new ArrayList<>(Arrays.asList(4,5,3)));
        Student s2 = new Student("Petya", new Rule2To5(), new ArrayList<>(Arrays.asList(4,5,5)));
        Student s3 = new Student("Vasya", new Rule2To5(), new ArrayList<>(Arrays.asList(4,4,4)));
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));*/
    }
}
