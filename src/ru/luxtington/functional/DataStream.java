package ru.luxtington.functional;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DataStream<T> {

    private List<T> lst;  // elements of stream

    private DataStream(List<T> lst){
        this.lst = lst;
    }

    public static <T>DataStream<T> of(List<T> lst){
        return new DataStream<>(lst);
    }

    public <O> DataStream<O> map(Applier<O, T> applier){

        List<O> newLst= new ArrayList<>();

        for (int i=0; i < lst.size(); i++)
            newLst.add(applier.apply(lst.get(i)));

        return DataStream.of(newLst);
    }

    public DataStream<T> filter(Filter<T> filter){

        List<T> newLst = new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            if (filter.filtrate(lst.get(i)))
                newLst.add(lst.get(i));
        }

        return DataStream.of(newLst);
    }

    public T reduce(Reductor<T> reductor, @NotNull T init){ // раскрутить действия
        T res = init;
        for (T t : lst){
            // actions
            res = reductor.reduce(res, t);
        }
        return res;
    }

    public <R> R collect(MyBiConsumer<R, T> cons, Supplier<R> sup){ // раскрутить действия
        R result = sup.get();

        for (T t : lst)
            cons.accept(result, t);

        return result;
    }
}
