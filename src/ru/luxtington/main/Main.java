package ru.luxtington.main;

import ru.luxtington.functional.Applier;
import ru.luxtington.functional.DataStream;
import ru.luxtington.functional.Filter;
import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.points.Point2D;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

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

        DataStream<Point2D> ds = DataStream.of(points);

        Polyline<Point2D> pol = ds
                .map(point -> new Point2D(point.x +5, point.y + 5))
                .filter(point -> point.x > 0 && point.y >0)
                .collect(Polyline::addPoint, Polyline::new);

        System.out.println(pol);
    }
}
