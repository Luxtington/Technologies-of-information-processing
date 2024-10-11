package OOP.geometricShapes;

public class Main
{
    public static void main(String[] args)
    {
        Square sq1 = new Square(new Point(6,7), 9);
        System.out.println(sq1.getPolyline());
    }
}
