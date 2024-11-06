package oop.differentThings.numbers;

public class IntegerNumber extends Number implements Summable{

    private final int value;

    public IntegerNumber(int value){
        this.value = (Integer) value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

}
