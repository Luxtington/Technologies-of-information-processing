package ru.luxtington.functional.stream;

public class FilterAction<T, R> implements Actionable<T,R>{

    private Filter<T> filter;

    public FilterAction(Filter filter){
        this.filter = filter;
    }

    @Override
    public R execute(T element) {
        return filter.filtrate(element) ?  (R)element : null;
    }
}
