package ru.luxtington.functional.macros;

public class FilterAction<T,R> implements Action<T,R>{
    Filter<T> filter;

    public FilterAction(Filter<T> filter) {
        this.filter = filter;
    }

    @Override
    public R execute(T elem) {
        if (filter.filtrate(elem))
            return (R)elem;
        return null;
    }
}
