package oop.geometricShapes;

public class Rectangle extends Figure{

    private int firstSide;
    private int secondSide;

    public Rectangle(Point2D leftUpPoint, int firstSide, int secondSide){
        super(leftUpPoint);
        setSides(firstSide, secondSide);
    }

    public int getFirstSide(){
        return firstSide;
    }
    public int getSecondSide(){
        return secondSide;
    }

    public void setFirstSide(int firstSide) {
        if (firstSide < 1)
            throw new IllegalArgumentException("Incorrect side's value");
        this.firstSide = firstSide;
    }

    public void setSecondSide(int secondSide) {
        if (secondSide < 1)
            throw new IllegalArgumentException("Incorrect side's value");
        this.secondSide = secondSide;
    }

    public void setSides(int firstSide, int secondSide){
        setFirstSide(firstSide);
        setSecondSide(secondSide);
    }

    @Override
    public double square(){
        return firstSide * secondSide;
    }

    public String toString() {
        return "Rectangle in point " + super.beginPoint + " with the first side's size = " + firstSide + ", second side's size = " + secondSide;
    }
}
