package ru.luxtington.functional.macros;

import java.util.*;

public class Macro<T> implements Action<T, T> {
    String title;
    List<T> data = new ArrayList<>();
    private List<Action<T, ?>> actions = new ArrayList<>();
    private static Map<Integer, Macro<?>> allMacros = new HashMap<>();

    public static <T> Macro of(String title, List<T> data) {
        if (allMacros.containsKey(Objects.hash(title)))
            return allMacros.get(Objects.hash(title));

        Macro<T> newMacro = new Macro<>(title, data);
        allMacros.put(Objects.hash(title), newMacro);
        return newMacro;
    }

    private Macro(String title, List<T> data) {
        this.title = title;
        this.data = new ArrayList<>(data);
    }

    @Override
    public T execute(T elem) {
        if (actions.isEmpty())
            return elem;

        Object tmp = elem;
        for (Action<T, ?> action : actions){
            tmp = action.execute((T)tmp);
            if (tmp == null)
                break;
        }
        return (T) tmp;
    }

    public <R> Macro<R> map(Applier<T,R> applier){
        Macro newMacro = new Macro(applier.hashCode() + "", List.of());
        newMacro.actions.add(new MapAction<>(applier));
        actions.add(newMacro);
        //actions.add(new MapAction<>(applier));
        return (Macro<R>) this;
    }

    public Macro<T> filter(Filter<T> filter){
        Macro newMacro = new Macro(filter.hashCode() + "", List.of());
        newMacro.actions.add(new FilterAction<>(filter));
        actions.add(newMacro);
        //actions.add(new FilterAction<>(filter));
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
