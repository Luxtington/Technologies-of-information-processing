package oop.basicLessons.lesson1_2.homework;

public class Runner
{
    public static void main(String[] args)
    {
        /*Point p1 = new Point(1,3);
        Point p2 = new Point(23,8);
        Point p3 = new Point(5,10);
        Point p4 = new Point(25,10);

        Point p5 = new Point(14,78); // help points for the first line
        Point p6 = new Point(32,80);

        Line l1 = new Line(p1, p2);
        Line l2 = new Line(p3, p4);
        Line l3 = new Line(p1, p4);

        System.out.println(l1 + " ||| " + l2 + " ||| " + l3);

        p1.updatePointCoords(2,6);
        p4.updatePointCoords(50,20);
        System.out.println(l1 + " ||| " + l2 + " ||| " + l3);

        l1.updateLineCoords(p5, p6); // updating line's 1 coords

        System.out.println(l1 + " ||| " + l2 + " ||| " + l3);*/

        /*Worker person1 = new Worker("Petrov");
        Worker person2 = new Worker("Kozlov");
        Worker person3 = new Worker("Sidorov");
        Worker person4 = new Worker("Oslov");
        Worker person5 = new Worker("Milov");

        Department dep1 = new Department("IT");
        dep1.chief = person2;

        Department dep2 = new Department("SMM");

        person1.setDepartment(dep1);
        person2.setDepartment(dep1);
        person3.setDepartment(dep1);
        person5.setDepartment(dep2);

        System.out.println(person1 + "\n" + person2 + "\n" + person3 + "\n" + person4 + "\n" + person5);*/

        /*FullName ex1 = new FullName("Kleopatra");
        FullName ex2 = new FullName("Pushkin", "Aleksandr", "Sergeevich");
        FullName ex3 = new FullName("Majakovskiy", "Vladimir");

        Human pers1 = new Human(ex1, 152);
        Human pers2 = new Human(ex2, 167);
        Human pers3 = new Human(ex3, 189);

        System.out.println(pers1 + " | " + pers2 + " | " + pers3);*/

        FullName ex1 = new FullName();
        ex1.surname = "Chudov";
        FullName ex2 = new FullName();
        ex2.name = "Petr";
        FullName ex3 = new FullName();
        ex3.name = "Boris";

        Person pers1 = new Person(ex1);
        Person pers2 = new Person(ex2, pers1);
        Person pers3 = new Person(ex3, pers2);

        System.out.println(pers1 + " | " + pers2 + " | " + pers3);
    }
}
