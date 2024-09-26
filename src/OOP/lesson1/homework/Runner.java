package OOP.lesson1.homework;

public class Runner
{
    public static void main(String[] args)
    {
        Point p1 = new Point(4,7);
        Point p2 = new Point(1,4);
        Point p3 = new Point(6,9);
        System.out.printf("%s, %s, %s\n", p1.toString(), p2.toString(), p3.toString());

        Human pers1 = new Human("Kleopatra", 152);
        Human pers2 = new Human("Pushkin", 167);
        Human pers3 = new Human("Vladimir", 189);
        System.out.printf("%s; %s; %s\n", pers1.toString(), pers2.toString(), pers3.toString());
        // features
        Human pers4 = new Human("Normis", 110);
        pers4.set_height(115);
        System.out.println(pers4.get_height());

        FullName ex1 = new FullName("Petrov", "Petr", "Petrovich");
        FullName ex2 = new FullName("Sidorov", "Vasiliy");
        FullName ex3 = new FullName("Kozlov");
        System.out.printf("%s; %s; %s\n", ex1.toString(), ex2.toString(), ex3.toString());

        Time time1 = new Time(85139);
        System.out.println(time1.toString());

        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);
        System.out.printf("%s %s %s\n", house1.toString(), house2.toString(), house3.toString());
    }
}