package ru.luxtington.main;

import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point3D;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Line<Point3D> l2 = Line.createLine2D(1, 2, 3, 4);
        //l1.setBeginPoint(new Point3D(1,2,3));
        //l1.setEndPoint(new Point3D(3,4,5));
        //Point2D p1 = l1.getBeginPoint(), p2 = l1.getEndPoint();
        //System.out.println(p1 + " | " + p2);
        System.out.println(l2);*/

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
                new Applier<Integer, String>() {
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

        /*Integer initialNumber = 1;
        Storage<Integer> res = TesterG.makeReducer(new ArrayList<Integer>(List.of(-1, 3, -7, 10)),
                new Reducer<Integer, Integer>() {
                    @Override
                    public Integer reduce(Integer value, Integer elem) {
                        value+=elem;
                        return value;
                    }
                }, initialNumber);

        System.out.println(res);

        Integer initialNumber = 0;
        List<Integer> lst1 = List.of(1,2,3,1), lst2 = List.of(5,6,7);
        List<List<Integer>> mainLst = List.of(lst1, lst2);

        Storage<Integer> res = TesterG.makeReducer(mainLst,
                new Reducer<Integer, List<Integer>>() {
                    @Override
                    public Integer reduce(Integer value, List<Integer> elem) {
                        value+=elem.size();
                        return value;
                    }
                }, initialNumber);

        System.out.println(res);*/

        /*List<Integer> lstTest = List.of(1,-2,3,-7);
        Supplier<List<List<Integer>>> supplier = new Supplier() {
            @Override
            public Object get() {
                List<List<Integer>> res = new ArrayList<>();
                res.add(new ArrayList<>());
                res.add(new ArrayList<>());
                return res;
            }
        };
        var res = TesterG.collect(lstTest,
                new MyBiConsumer<List<List<Integer>>, Integer>() {
                    @Override
                    public void accept(List<List<Integer>> lst, Integer val) {
                        if (val < 0)
                            lst.get(0).add(val);
                        else
                            lst.get(1).add(val);
                    }
                }, supplier);

        System.out.println(res);*/

        List<Point2D> points = List.of(new Point2D(1,2), new Point2D(3, 4),  new Point2D(-33, 4));

        Polyline<Point2D> newPolyline = TesterG.makeMovedPolyline(points,
                new Applier<Point2D, Point2D>() {
                    @Override
                    public Point2D apply(Point2D point) {
                        return new Point2D(point.x + 5, point.y);
                    }
                },
                new Filter<Point2D>() {
                    @Override
                    public boolean filtrate(Point2D point) {
                        return (point.x > 0);
                    }
                },
                new MyBiConsumer<Polyline<Point2D>, Point2D>() {
                    @Override
                    public void accept(Polyline<Point2D> polyline, Point2D point){
                        polyline.addPoint(point);
                    }
                });
        System.out.println(newPolyline);
    }
}
