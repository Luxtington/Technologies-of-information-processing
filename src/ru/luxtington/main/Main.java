package ru.luxtington.main;

import ru.luxtington.oop.generics.Box;
import ru.luxtington.oop.generics.Stack;
import ru.luxtington.oop.generics.Storage;
import ru.luxtington.oop.geometry.figures.Line;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point3D;
import ru.luxtington.oop.people.studying.Rule2To5;
import ru.luxtington.oop.people.studying.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Box b1 = new Box<Integer>(3);
        //b1.pushItem(4);
        System.out.println((Integer) b1.popItem());
        b1.pushItem(4);
        System.out.println(b1);*/

        /*Stack<String> st1 = new Stack<>("abc1");
        st1.push("qwe2");
        st1.push("rty3");
        st1.push("qqq4");
        System.out.println("pop element = " + st1.pop());
        System.out.println("up element = " + st1.peek());
        System.out.println(st1);*/

        /*Storage<Integer> storage1 = new Storage<>(null, 0);
        System.out.println(storage1.getItem());
        Storage<Integer> storage2 = new Storage<>(99, -1);
        Storage<String> storage3 = new Storage<>(null, "default");
        System.out.println(storage3.getItem());
        Storage<String> storage4 = new Storage<>("hello", "hello world");*/

        /*Student s1 = new Student("Vasya", new Rule2To5(), new ArrayList<>(Arrays.asList(4,5,3)));
        Student s2 = new Student("Petya", new Rule2To5(), new ArrayList<>(Arrays.asList(4,5,5)));
        Student s3 = new Student("Roma", new Rule2To5(), new ArrayList<>(Arrays.asList(4,4,4)));
        Student s4 = new Student("Gena", new Rule2To5(), new ArrayList<>(Arrays.asList(5,4,3)));

        List<Student> studentsList = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));
        for (int i=0; i < studentsList.size() -1; i++){
            if ((studentsList.get(i).compareTo(studentsList.get(i+1))) < 0)
                System.out.println("He is worse than next");
            else if ((studentsList.get(i).compareTo(studentsList.get(i+1))) > 0)
                System.out.println("He is better than next");
            else
                System.out.println("They're equals by marks");
        }*/

        Class<Point2D> p2D = Point2D.class;
        Class<Point3D> p3D = Point3D.class;
        Line<Point3D> l1 = new Line<>(p3D);
        l1.setBeginPoint(new Point3D(1,2,3));
        l1.setEndPoint(new Point3D(3,4,5));
        Point2D p1 = l1.getBeginPoint(), p2 = l1.getEndPoint();
        System.out.println(p1 + " | " + p2);
        System.out.println(l1);
    }
}
