package OOP.lesson3.homework;

public class Main
{
    public static void main(String[] args) {
        /*int [] marks1 = {3, 4, 5};
        int [] marks2 = new int[marks1.length];

        Student st1 = new Student("Vasya", marks1);
        Student st2 = new Student("Petya");
        st2.marks = st1.marks;
        st2.marks[0] = 5;

        System.out.println(st1);
        System.out.println(st2);

        Student st3 = new Student("Andrew", marks2);
        for (int i=0; i<st1.marks.length; i++)
            st3.marks[i] = st1.marks[i];

        st1.marks[st1.marks.length-1] = 2;

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);*/

        /*Point p1 = new Point(1,5);
        Point p2 = new Point(2,8);
        Point p3 = new Point(5,3);
        Point p4 = new Point(2,-5);
        Point p5 = new Point(4,-8);

        Point [] points1 = {p1, p2, p3};
        Point [] points2 = {p1, p4, p5, p3};

        Polyline line1 = new Polyline(points1);
        Polyline line2 = new Polyline(points2);

        System.out.println(line1);
        System.out.println(line2);

        line1.points[0].updateCoords(-1, -5);

        System.out.println(line1);
        System.out.println(line2);*/

        /*City cityA = new City("A"), cityB = new City("B"), cityC = new City("C");
        City cityD = new City("D"), cityE = new City("E"), cityF = new City("F");
        City[] allCities = {cityA, cityB, cityC, cityD, cityE, cityF}; // for set ways for one city

        Way wayA1 = new Way(cityB, 5), wayA2 = new Way(cityD, 6), wayA3 = new Way(cityF, 1);
        Way wayB1 = new Way(cityA, 5), wayB2 = new Way(cityC, 3);
        Way wayC1 = new Way(cityB, 3), wayC2 = new Way(cityD, 4);
        Way wayD1 = new Way(cityA, 6), wayD2 = new Way(cityC, 4), wayD3 = new Way(cityE, 2);
        Way wayE1 = new Way(cityF, 2);
        Way wayF1 = new Way(cityB, 1), wayF2 = new Way(cityE, 2);

        Way[] aAllAWays = {wayA1, wayA2, wayA3};
        Way[] bAllAWays = {wayB1, wayB2};
        Way[] cAllAWays = {wayC1, wayC2};
        Way[] dAllAWays = {wayD1, wayD2, wayD3};
        Way[] eAllAWays = {wayE1};
        Way[] fAllAWays = {wayF1, wayF2};

        Way[][] allWays = {aAllAWays, bAllAWays, cAllAWays, dAllAWays, eAllAWays, fAllAWays}; // for set ways for one city

        for (int i = 0; i < City.cityNumber; i++) {
            allCities[i].setWays(allWays[i]);
            System.out.println(allCities[i]);
        }*/

        Worker pers1 = new Worker("Petrov");
        Worker pers2 = new Worker("Kozlov");
        Worker pers3 = new Worker("Sidorov");

        Department dep1 = new Department("IT", pers2);
        pers1.setDepartment(dep1);
        pers2.setDepartment(dep1);
        pers3.setDepartment(dep1);

        System.out.println(pers1 + " | " + pers2 + " | " + pers3);
        System.out.println(pers3.showColleagues());

    }
}
