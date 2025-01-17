package ru.luxtington.functional.stream;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DataStream<T> {

    private Iterable<T> lst;  // elements of stream
    private List<Actionable<T, ?>> actions;

    private DataStream(Iterable<T> lst){
        this.lst = lst;
        actions = new ArrayList<>();
    }

    public static <T>DataStream<T> of(Iterable<T> lst){
        return new DataStream<>(lst);
    }

    public <R> DataStream<R> map(Applier<R, T> applier){
        actions.add(new MapAction<T,R>(applier));
        return (DataStream<R>) this;
    }

    public DataStream<T> filter(Filter<T> filter){
        actions.add(new FilterAction<T,T>(filter));
        return this;
    }

    public T reduce(Reductor<T> reductor, @NotNull T init){
        T res = init;
        for (T t : lst){
            Object tmp = t;
            for (Actionable<T,?> act : actions){
                tmp = act.execute((T)tmp);
                //System.out.println("tmp after execute: "+tmp);
                if (tmp == null)
                    break;
            }
            if (tmp != null){
                res = reductor.reduce(res, (T)tmp);
            }
        }
        return res;
    }

    public <R> R collect(MyBiConsumer<R, T> cons, Supplier<R> sup){
        R result = sup.get();

        for (T t : lst){
            Object tmp = t;
            for (Actionable<T,?> act : actions){
                tmp = act.execute((T)tmp);
                if (tmp == null)
                    break;
            }
            if (tmp != null){
                cons.accept(result, t);
            }
        }
        return result;
    }
}
