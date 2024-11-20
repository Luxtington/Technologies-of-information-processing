package ru.luxtington.oop.different.cities;

import ru.luxtington.oop.geometry.points.Point2D;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class City {
    String title;
    private List<Way> ways = new ArrayList<>();

    private static int cityNumber; // for comfortable print in Main

    {
        cityNumber++;
    }

    public City(String title, List<Way> ways) {
        this.title = title;
        addWays(ways);
    }

    public City(String title) {
        this(title, new ArrayList<>());
    }

    public static int getCityNumber() {
        return cityNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setWays(List<Way> ways) {
        this.ways = new ArrayList<>();
        this.addWays(ways);
    }

    public List<Way> getWays() {
        return new ArrayList<>(ways);
    }

    public void addWays(List<Way> ways) {
        for (int i = 0; i < ways.size(); i++) {
            this.addWay(ways.get(i));
        }
    }

    public void addWay(Way newWay) {
        //System.out.println("2 - father");
        if (newWay == null) return;
        if (this.ways.isEmpty() && newWay.city.getWays().isEmpty())
            this.ways.add(newWay);
        else {
            for (int i = 0; i < ways.size(); i++) // проверка на схожие пути в этом городе
            {
                if (this.ways.get(i).city == newWay.city) {
                    this.ways.get(i).setCost(newWay.getCost());
                    return;
                }
            }
            for (int i = 0; i < newWay.city.getWays().size(); i++) // проверка на схожие пути из другого города в этот
            {
                Way tmpWay = newWay.city.getWays().get(i); // текущий путь из города, куда добавляем, в этот
                if (tmpWay.city == this && tmpWay.getCost() != newWay.getCost()) //без проверки на цену не сможем добавлять существующие пути, которые есть в добавленном городе, но нет в этом
                    tmpWay.setCost(newWay.getCost());
            }
            this.ways.add(newWay);
        }
    }

    public void removeWay(Way deletWay) {
        if (this.ways.contains(deletWay)) {
            this.ways.remove(deletWay);
        }

        for (int i = 0; i < deletWay.city.getWays().size(); i++) {
            Way tmpWay = deletWay.city.getWays().get(i); // если будет инкапсуляция city - GG

            if (tmpWay.city == this)
                deletWay.city.removeWay(tmpWay);
        }
    }

    public void removeWay(City deletedCity) {
        for (int i = 0; i < ways.size(); i++) {
            if (ways.get(i).city == deletedCity)
                ways.remove(ways.get(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;

        if (ways.isEmpty() && city.ways.isEmpty())
            return false;

        if (ways.size() == city.ways.size()){
            for (int i=0; i < ways.size(); i++){
                if (!((city.ways.contains(ways.get(i))) && (ways.contains(city.ways.get(i)))))
                    return false;
            }
            return true;
        }
        else
            return false;

        //return Objects.equals(ways, city.ways);
    }

    @Override
    public int hashCode() {

        int hashCodes = 0;

        for (int i=0; i < ways.size(); i++){
            hashCodes += ways.get(i).hashCode();
        }

        return hashCodes;
        //return Objects.hashCode(ways);  <=> ways.hashCode();
    }

    public String toString() {
        String res = title + "-ways: ";
        res += ways.toString();
        return res;
    }
}
