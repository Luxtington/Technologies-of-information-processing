package oop.geometricShapes;

public class Circle extends Figure{

    private int radius;

    public Circle(Point2D centralPoint, int radius){
        super(centralPoint);
        setRadius(radius);
    }

    public void setRadius(int radius){
        if (radius < 1)
            throw new IllegalArgumentException("Incorrect radius's value");
        this.radius = radius;
    }

    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
}
