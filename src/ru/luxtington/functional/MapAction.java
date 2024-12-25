package ru.luxtington.functional;

public class MapAction<T,R> implements Actionable<T,R>{

    private Applier<R,T> applier;

    public MapAction(Applier<R,T> applier) {
        this.applier = applier;
    }

    @Override
    public R execute(T element) {
        return applier.apply(element);
    }
}
