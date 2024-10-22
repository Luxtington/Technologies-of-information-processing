package OOP.differentThings;

import java.util.List;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) {

        /*House h1 = new House(2);
        System.out.println(h1);*/

        /*Time t1 = new Time(86399);
        System.out.println(t1);*/

        //System.out.println(new Fraction(1, 2).plus(new Fraction(-1, 15)));

        /*Gun gun1 = new Gun(7);
        gun1.loadBullets(3);
        for (int i=0; i<5; i++) gun1.makeShot();
        gun1.loadBullets(8);
        for (int i=0; i<2; i++) gun1.makeShot();
        gun1.removeBullets();
        gun1.makeShot();*/

        City cityA = new City("A"), cityB = new City("B"), cityC = new City("C");
        City cityD = new City("D"), cityE = new City("E"), cityF = new City("F");

        List<City> allCities = new ArrayList<City>();
        allCities.add(cityA);
        allCities.add(cityB);
        allCities.add(cityC);
        allCities.add(cityD);
        allCities.add(cityE);
        allCities.add(cityF);

        Way wayA1 = new Way(cityB, 5), wayA2 = new Way(cityD, 6), wayA3 = new Way(cityF, 1);
        Way wayB1 = new Way(cityA, 5), wayB2 = new Way(cityC, 3);
        Way wayC1 = new Way(cityB, 3), wayC2 = new Way(cityD, 4);
        Way wayD1 = new Way(cityA, 6), wayD2 = new Way(cityC, 4), wayD3 = new Way(cityE, 2);
        Way wayE1 = new Way(cityF, 2);
        Way wayF1 = new Way(cityB, 1), wayF2 = new Way(cityE, 2);
        //Way wayAExc = new Way(cityB, 7);

        List<Way> aAllAWays = new ArrayList<Way>();

        aAllAWays.add(wayA1);
        aAllAWays.add(wayA2);
        aAllAWays.add(wayA3);
        //aAllAWays.add(new Way(cityF, 7)); //exc - попытка добавления второго пути из одного и того же города

        List<Way> bAllAWays = new ArrayList<Way>();
        bAllAWays.add(wayB1);
        bAllAWays.add(wayB2);
        //aAllAWays.add(wayAExc); // уберем А1, оставив В1, при добавлении пути А1 с другой ценой - ошибка

        List<Way> cAllAWays = new ArrayList<Way>();
        cAllAWays.add(wayC1);
        cAllAWays.add(wayC2);

        List<Way> dAllAWays = new ArrayList<Way>();
        dAllAWays.add(wayD1);
        dAllAWays.add(wayD2);
        dAllAWays.add(wayD3);

        List<Way> eAllAWays = new ArrayList<Way>();
        eAllAWays.add(wayE1);

        List<Way> fAllAWays = new ArrayList<Way>();
        fAllAWays.add(wayF1);
        fAllAWays.add(wayF2);

        List<List<Way>> allWays = new ArrayList<List<Way>>();
        allWays.add(aAllAWays);
        allWays.add(bAllAWays);
        allWays.add(cAllAWays);
        allWays.add(dAllAWays);
        allWays.add(eAllAWays);
        allWays.add(fAllAWays);

        for (int i = 0; i < City.getCityNumber(); i++) // устанавливаем наборы путей городам
        {
            allCities.get(i).setWays(allWays.get(i));
            System.out.println(allCities.get(i));
        }

        cityA.removeWay(wayA1);
        System.out.println("---------");

        for (int i = 0; i < City.getCityNumber(); i++) // устанавливаем наборы путей городам
        {
            System.out.println(allCities.get(i));
        }
    }
}
