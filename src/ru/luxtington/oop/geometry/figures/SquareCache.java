package ru.luxtington.oop.geometry.figures;

public class SquareCache extends Square{

    private Square sq;
    private boolean flag = true;
    private double cacheArea;

    public SquareCache(Square sq) {
        super(sq.getLeftUpPoint(), sq.getSideSize());
        this.sq = sq;
    }

    @Override
    public double area(){
        if (flag){
            flag = false;
            cacheArea = sq.area();
        }
        return cacheArea;
    }

    @Override
    public void setSideSize(int side){
        flag = true;
        sq.setSideSize(side);
    }
}
