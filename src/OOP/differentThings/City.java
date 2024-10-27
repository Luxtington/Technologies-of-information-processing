package OOP.differentThings;

import java.util.List;
import java.util.ArrayList;

public class City {
    private String title;
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
        if (this.ways.isEmpty() && newWay.getCity().getWays().isEmpty())
            this.ways.add(newWay);
        else
        {
            for (int i = 0; i < ways.size(); i++) // проверка на схожие пути в этом городе
            {
                if (this.ways.get(i).getCity() == newWay.getCity())
                {
                    this.ways.get(i).setCost(newWay.getCost());
                    return;
                }
            }
            for (int i = 0; i < newWay.getCity().getWays().size(); i++) // проверка на схожие пути из другого города в этот
            {
                Way tmpWay = newWay.getCity().getWays().get(i); // текущий путь из города, куда добавляем, в этот
                if (tmpWay.getCity() == this && tmpWay.getCost() != newWay.getCost()) //без проверки на цену не сможем добавлять существующие пути, которые есть в добавленном городе, но нет в этом
                    tmpWay.setCost(newWay.getCost());
            }
            this.ways.add(newWay);
        }
    }

    public void removeWay(Way deletWay) {
        if (this.ways.contains(deletWay)) {
            this.ways.remove(deletWay);
        }

        for (int i = 0; i < deletWay.getCity().getWays().size(); i++) {
            Way tmpWay = deletWay.getCity().getWays().get(i); // если будет инкапсуляция city - GG

            if (tmpWay.getCity() == this)
                deletWay.getCity().removeWay(tmpWay);
        }
    }

    public void removeWay(City deletedCity)
    {
        for (int i=0; i < ways.size(); i++)
        {
            if (ways.get(i).getCity() == deletedCity)
                ways.remove(ways.get(i));
        }

        /*for (int i=0; i < deletedCity.getWays().size(); i++)
        {
            if (deletedCity.getWays().get(i).getCity() == this)
                deletedCity.getWays().remove(deletedCity.getWays().get(i));
        }*/ //никак не реализовать из-за хорошего геттера
    }

    public String toString() {
        String res = title + "-ways: ";
        res += ways.toString();
        return res;
    }
}
