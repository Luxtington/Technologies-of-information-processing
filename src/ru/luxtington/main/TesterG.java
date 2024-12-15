package ru.luxtington.main;

public class TesterG<T> {

    /*private List<T> lst;

    private DataStream(List <T> lst){
        this.lst = lst;
    }

    public Storage<Integer> summInts(List<Integer> nums){

        if (nums.isEmpty())
            return (Storage<Integer>)Storage.emptyStorage();

        int sum = 0;
        for (Integer num : nums)
            sum+=num;

        return Storage.of(sum);
    }

    public double findMax(@NotNull List<Box<? extends Number>> boxes){

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

    public Box<? super Point3D> pushPoint(Box<? super Point3D> box){
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
    }*/

    /*--------------------------------------------------------------------------*/

    /*public static <T>DataStream<T> of(List<T> obj){
        return new DataStream<>(obj);
    }

    public <T,O> List<O> function(@NotNull List<T> lst, Function<O, T> function){

        List<O> newLst= new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            newLst.add(function.apply(lst.get(i)));
        }

        return newLst;
    }

    public <R> DataStream<R> map(Function<T, R> function){
        List<R> newLt = new ArrayList<>(lst.size());
        for (T t : lst){
            newLt.add(function.apply(t));
        }
        DataStream<R> newDs = (DataStream<R>) this;
        newDs.lst = newLt;
        return newDs;
    }

    public <T> DataStream<T> doFiltration(Filter<T> filter){

        List<T> newLst = new ArrayList<>();

        for (int i=0; i < lst.size(); i++){
            if (filter.filtrate(lst.get(i)))
                newLst.add(lst.get(i));
        }

        return newLst;
    }

    public <T, R> Storage<R> makeReducer(@NotNull List<T> lst, Reducer<R,T> reducer, @NotNull R init){
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

    public <T, R> R collect(@NotNull List<T> lst, MyBiConsumer<R, T> cons, Supplier<R> sup){
        R result = sup.get();

        if (lst.isEmpty())
            return result;

        for (T t : lst){
            cons.accept(result, t);
        }

        return result;
    }*/

    /*public static <T extends Point2D, R> Polyline<T> makeMovedPolyline(List<T> points, Map<T, T> map, Filter<T> filter, MyBiConsumer<R, T> consumer){

        //List <T> movedPoints = new ArrayList<>();
        Polyline<T> polyline = new Polyline<>();

        for (int i=0; i < points.size(); i++){
            T currPoint = map.apply(points.get(i));
            if (filter.filtrate(currPoint))
                consumer.accept((R) polyline, currPoint);
        }
        return polyline;
    }*/
}