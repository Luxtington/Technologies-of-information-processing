package oop.differentThings.numbers;

public final class Fraction extends Number implements Summable {
    private final int numerator;
    private final int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;

        if (denominator < 0) throw new IllegalArgumentException("Incorrect denominator's value");
        this.denominator = denominator;
    }

    public Fraction plus(Fraction fraction) {
        return new Fraction(this.denominator * fraction.numerator + this.numerator * fraction.denominator, this.denominator * fraction.denominator);
    }

    public Fraction plus(int number) {
        return plus(new Fraction(number, 1));
    }

    public Fraction minus(Fraction fraction) {
        return new Fraction(this.numerator * fraction.denominator - this.denominator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction minus(int number) {
        return minus(new Fraction(number, 1));
    }

    public Fraction mult(Fraction fraction) {
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction mult(int number) {
        return mult(new Fraction(number, 1));
    }

    public Fraction div(Fraction fraction) {
        return new Fraction(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
    }

    public Fraction div(int number) {
        return div(new Fraction(number, 1));
    }

    @Override
    public int intValue() {
        return (int)numerator/denominator;
    }

    @Override
    public long longValue() {
        return (long)numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float)numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double)numerator/denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
