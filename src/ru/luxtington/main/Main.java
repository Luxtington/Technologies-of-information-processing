package ru.luxtington.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.math.BigInteger;
import ru.luxtington.oop.different.animals.birds.Parrot;
import ru.luxtington.oop.different.animals.birds.Sparrow;
import ru.luxtington.oop.different.animals.cats.Bot;
import ru.luxtington.oop.different.animals.cats.Cat;
import ru.luxtington.oop.different.numbers.Fraction;
import ru.luxtington.oop.geometry.figures.Line;
import ru.luxtington.oop.geometry.figures.Rectangle;
import ru.luxtington.oop.geometry.figures.Triangle;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.people.gunner.Shooter;
import ru.luxtington.oop.people.studying.Rule10To13;
import ru.luxtington.oop.people.studying.Rule2To5;
import ru.luxtington.oop.people.studying.Student;

import java.awt.Point;



public class Main {
    public static void main(String[] args) {

        /*System.out.println(Tester.summ(7, new Fraction(11,3), new Fraction(321,100), new BigInteger("12345678912345678912")));
        System.out.println(Tester.summAreas(new Rectangle(new Point2D(1,2),5,5), new Rectangle(new Point2D(1,2),5, 10)));
        System.out.println(Tester.summLength(new Line(1,2,4,5), new Line(7,8,9,10)));
        System.out.println(Tester.joinPolylines(new Rectangle(new Point2D(1,2), 3,4), new Triangle(new Point2D(3,4), new Point2D(1,0), new Point2D(0,3))));
        Tester.hearSongs(new Parrot("hallo"), new Sparrow());
        Tester.hearMeow(new Cat("Barsik"), new Bot("Anton"));
        Tester.hearShooter(new Shooter("Vasya"));

        //System.out.println(Tester.toPower(args[0], args[1]));
        System.out.println(Tester.toPower("2", "3"));

        Point2D p1 = new Point2D(1,2);
        Point p2 = new Point(3,4);
        System.out.println(p1 + " | " + p2);*/

        Student s1 = new Student("Petya", new Rule2To5(), new ArrayList<>(Arrays.asList(2,3,3)));
        Student s2 = new Student("Vasya", new Rule2To5(), new ArrayList<>(Arrays.asList(5,5,2)));
        Student s3 = new Student("Dima", new Rule10To13(), new ArrayList<>(Arrays.asList(12,12,12)));

        List <Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3));

        Tester.setMarkToStudents(students, 11);

        for (int i=0; i < students.size(); i++)
            System.out.println(students.get(i).getMarks());

    }
}
