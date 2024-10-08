package OOP.lesson1.homework;

public class Runner
{
    public static void main(String[] args)
    {
        Point p1 = new Point(4,7);
        Point p2 = new Point(1,4);
        Point p3 = new Point(6,9);
        System.out.printf("%s, %s, %s\n", p1, p2, p3);

        Human pers1 = new Human("Kleopatra", 152);
        Human pers2 = new Human("Pushkin", 167);
        Human pers3 = new Human("Vladimir", 189);
        System.out.printf("%s; %s; %s\n", pers1, pers2, pers3);
        // features
        Human pers4 = new Human("Normis", 110);
        pers4.setHeight(115);
        System.out.println(pers4.getHeight());

        FullName ex1 = new FullName("Petrov", "Petr", "Petrovich");
        FullName ex2 = new FullName("Sidorov", "Vasiliy");
        FullName ex3 = new FullName("Kozlov");
        System.out.printf("%s; %s; %s\n", ex1, ex2, ex3);

        Time time1 = new Time(85139);
        System.out.println(time1);

        House house1 = new House(1);
        House house2 = new House(5);
        House house3 = new House(23);
        System.out.printf("%s %s %s\n", house1, house2, house3);
    }
}
