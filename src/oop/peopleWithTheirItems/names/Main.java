package oop.peopleWithTheirItems.names;

public class Main {
    public static void main(String[] args) {
        //FullName test = new FullName(" "); // exc

        FullName f1 = new FullName("Petr", "Kozlov");
        FullName f2 = new FullName("Vasiliy");
        Person p1 = new Person(f1, 200);
        Person p2 = new Person(f2, 199, p1);
        //h2.getFather().height = 150;
        System.out.println(p2);
    }
}
