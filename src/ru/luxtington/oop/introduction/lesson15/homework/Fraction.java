package ru.luxtington.oop.introduction.lesson15.homework;

public class Fraction
{
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction plus(Fraction fraction)
    {
        Fraction newFraction = new Fraction(0 ,0);
        newFraction.numerator = this.denominator * fraction.numerator + this.numerator * fraction.denominator;
        newFraction.denominator = this.denominator * fraction.denominator;
        return newFraction;
    }

    public Fraction minus(Fraction fraction)
    {
        Fraction newFraction = new Fraction(0 ,0);
        newFraction.numerator = this.numerator * fraction.denominator - this.denominator * fraction.numerator;
        newFraction.denominator = this.denominator * fraction.denominator;
        return newFraction;
    }

    public Fraction mult(Fraction fraction)
    {
        return new Fraction(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction div(Fraction fraction)
    {
        return new Fraction(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
    }

    public String toString()
    {
        return numerator + "/" + denominator;
    }
}
