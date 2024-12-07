package ru.luxtington.main;

import org.jetbrains.annotations.NotNull;
import ru.luxtington.oop.generics.Box;
import ru.luxtington.oop.generics.Storage;
import ru.luxtington.oop.geometry.figures.Polyline;
import ru.luxtington.oop.geometry.points.Point2D;
import ru.luxtington.oop.geometry.points.Point3D;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class TesterG {

    public static Storage<Integer> summInts(List<Integer> nums){

        if (nums.isEmpty())
            return (Storage<Integer>)Storage.emptyStorage();

        int sum = 0;
        for (Integer num : nums)
            sum+=num;

        return Storage.of(sum);
    }

    public static double findMax(@NotNull List<Box<? extends Number>> boxes){

        List<Box<? extends Number>> copyBoxes = new ArrayList<>(boxes);

        double max = Double.NEGATIVE_INFINITY;

        for (int i=0; i < copyBoxes.size(); i++){
            if (copyBoxes.get(i).isEmpty())
                continue;

            double curr = copyBoxes.get(i).popItem().doubleValue();
            if (curr > max)
                max = curr;
        }
        return max;
    }

    public static Box<? super Point3D> pushPoint(Box<? super Point3D> box){
        box.popItem();
        Random r = new Random();
        int x = r.nextInt()%20, y = r.nextInt()%20, z = r.nextInt()%20;
        box.pushItem(new Point3D(x,y,z));
        return box;
    }

    public static void fillList(@NotNull List<? super Number> numbers){
        Random r = new Random();
        for (int i=0; i < numbers.size(); i++)
            numbers.set(i, Math.abs(r.nextInt()%101));
    }

    /*--------------------------------------------------------------------------*/

    public static <T,O> List<O> function(@NotNull List<T> lst, Applier<O, T> applier){

        List<O> newLst= new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            newLst.add(applier.apply(lst.get(i)));
        }

        return newLst;
    }

    public static <T> List<T> doFiltration(@NotNull List<T> lst, Filter<T> filter){

        List<T> newLst = new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            if (filter.filtrate(lst.get(i)))
                newLst.add(lst.get(i));
        }

        return newLst;
    }

    public static <T, R> Storage<R> makeReducer(@NotNull List<T> lst, Reducer<R,T> reducer, @NotNull R init){
        //return reducer.reduce(lst); my decision was wrong, cause there's no loop here
        if (lst.isEmpty())
            return Storage.of(init);
        R value = init;
        for (int i=0; i < lst.size(); i++){
            value = reducer.reduce(value, lst.get(i));
            //reducer.reduce(value, lst.get(i));
        }
        return Storage.of(value);
    }

    public static <T, R> R collect(@NotNull List<T> lst, MyBiConsumer<R, T> cons, Supplier<R> sup){
        R result = sup.get();

        for (T t : lst){
            cons.accept(result, t);
        }

        return result;
    }

    public static <T extends Point2D, R> Polyline<T> makeMovedPolyline(List<T> points, Applier<T, T> applier, Filter<T> filter, MyBiConsumer<R, T> consumer){

        //List <T> movedPoints = new ArrayList<>();
        Polyline<T> polyline = new Polyline<>();

        for (int i=0; i < points.size(); i++){
            T currPoint = applier.apply(points.get(i));
            if (filter.filtrate(currPoint))
                consumer.accept((R) polyline, currPoint);
        }
        return polyline;
    }
}