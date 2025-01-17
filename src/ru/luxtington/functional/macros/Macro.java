package ru.luxtington.functional.macros;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class Macro<T> {
    String title;
    List<T> data = new ArrayList<>();
    private List<Action<T, ?>> actions = new ArrayList<>();

    public static <T> Macro of(String title, List<T> data) {
        return new Macro<>(title, data);
    }

    private Macro(String title, List<T> data) {
        this.title = title;
        this.data = new ArrayList<>(data);
    }

    public <R> Macro<R> map(Applier<T,R> applier){
        actions.add(new MapAction<>(applier));
        return (Macro<R>) this;
    }

    public Macro<T> filter(Filter<T> filter){
        actions.add(new FilterAction<>(filter));
        return this;
    }

    public T reduce(T init, Consumer<T> consumer){
        T res = init;
        for (T elem : data){
            Object tmp = elem;
            for (Action<T, ?> action : actions){
                tmp = action.execute((T)tmp);
                if (tmp == null)
                    break;
            }
            if (tmp != null)
                res = consumer.reduce(res, (T)tmp);
        }
        return res;
    }

    public void addData(T element){
        data.add(element);
    }

    public void removeElement(T element){
        if (!data.contains(element))
            throw new NoSuchElementException("No such element in data list");
        data.remove(element);
    }

    @Override
    public String toString() {
        return title + ": " + data;
    }
}
