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

        Line<Point3D> l2 = Line.createLine2D(1, 2, 3, 4);
        //l1.setBeginPoint(new Point3D(1,2,3));
        //l1.setEndPoint(new Point3D(3,4,5));
        //Point2D p1 = l1.getBeginPoint(), p2 = l1.getEndPoint();
        //System.out.println(p1 + " | " + p2);
        System.out.println(l2);

        /*Box<Integer> b1= new Box<>(1);
        Box<Double> b2= new Box<>(3.0);
        Box<Integer> b3= new Box<>(null);
        System.out.println(TesterG.findMax(List.of(b1, b2, b3)));*/

        //Box<Point3D> boxResult = (Box<Point3D>) TesterG.pushPoint(new Box<Point3D>(null));
        //System.out.println(boxResult);

        /*List<Number> lst1 = new ArrayList<>(List.of(1.0, 2.0, 3.0)); // Double = crash
        TesterG.fillList(lst1);
        System.out.println(lst1);*/


        /*List<Integer> ans = TesterG.function(new ArrayList<String>(List.of("qwerty", "abc", "quebro")),
                new Actor<Integer, String>() {
                    @Override
                    public Integer apply(String str) {
                        return str.length();
                    }
                });
        System.out.println(ans);*/

        /*List<String> answer = TesterG.doFiltration(new ArrayList<String>(List.of("qa","qwerty", "abc", "quebro", "qw")),
                new Filter<String>() {
                    @Override
                    public boolean filtrate(String str) {
                        return str.length() > 2;
                    }
                });
        System.out.println(answer);*/

        /*Integer result = TesterG.doShorter(new ArrayList<Integer>(List.of(1, 3, -7)),
                new Shortener<Integer>() {
                    @Override
                    public Storage<Integer> makeShorter(List<Integer> lst) {
                        Integer sum = 0;
                        for (int i=0; i < lst.size(); i++)
                            sum += lst.get(i);

                        return Storage.of(sum);
                    }
                }).getItem(-99);
        System.out.println(result);*/
    }


}
