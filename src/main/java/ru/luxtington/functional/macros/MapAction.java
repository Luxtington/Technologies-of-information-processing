package ru.luxtington.functional.macros;

public class MapAction<T,R> implements Action<T,R>{
    private Applier<T,R> applier;

    public MapAction(Applier<T, R> applier) {
        this.applier = applier;
    }

    @Override
    public R execute(T elem) {
        return applier.apply(elem);
    }
}
