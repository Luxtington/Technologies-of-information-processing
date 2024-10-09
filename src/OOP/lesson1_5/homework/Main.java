package OOP.lesson1_5.homework;

import OOP.lesson1_3.homework.Point;

public class Main
{
    public static void main(String[] args)
    {
        /*Gun gun = new Gun(3);
        for (int i=0; i<5; i++)
            gun.makeShot();*/

        /*Cat cat1 = new Cat("Barsik");
        System.out.println(cat1.makeMeow());
        System.out.println(cat1.makeMeow(3));*/

        /*Line l1 = new Line(new Point(1,1), new Point(10,15));
        System.out.println(l1.calculateLength());*/

        /*Fraction f1 = new Fraction(1, 2), f2 = new Fraction(1, 3);
        System.out.println(f1 + " * " + f2 + " = " + f1.mult(f2));
        System.out.println(f1.mult(f2).plus(f1).minus(f2).div(f1));*/

        Square s1 = new Square(new Point(5, 3), 2);
        System.out.println(s1);
        System.out.println(s1.getPolyline());

    }
}
