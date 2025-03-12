package ru.luxtington.oop.different.numbers;

public class FractionGenerator {

    private static final FractionGenerator fractionGenerator = new FractionGenerator();

    private FractionGenerator() {
    }

    public static FractionGenerator createFractionGenerator(){
        return fractionGenerator;
    }

    public Fraction generateFraction(int num, int den){
        return Fraction.createFraction(num, den);
    }

    @Override
    public String toString() {
        return "This is the fraction generator";
    }
}
