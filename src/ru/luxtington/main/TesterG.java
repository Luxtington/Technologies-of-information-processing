package ru.luxtington.main;

import org.jetbrains.annotations.NotNull;
import ru.luxtington.oop.generics.Box;
import ru.luxtington.oop.generics.Storage;
import ru.luxtington.oop.geometry.points.Point3D;
import ru.luxtington.oop.people.gunner.Shooter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static <T,O> List<O> function(@NotNull List<T> lst, Actor<O, T> actor){

        List<O> newLst= new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            newLst.add(actor.apply(lst.get(i)));
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

    public static <T> Storage<T> doShorter(@NotNull List<T> lst, Shortener<T> shortener){
        return shortener.makeShorter(lst);
    }

}
