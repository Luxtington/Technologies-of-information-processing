package OOP.differentThings;

import java.util.List;
import java.util.ArrayList;

public class City
{
    private String title;
    private List<Way> ways = new ArrayList<>();

    private static int cityNumber; // for comfortable print in Main

    {
        cityNumber++;
    }

    public City(String title, List<Way> ways)
    {
        this.title = title;
        addWays(ways);
    }

    public City(String title)
    {
        this(title, new ArrayList<>());
    }

    public static int getCityNumber()
    {
        return cityNumber;
    }

    public String getTitle()
    {
        return title;
    }

    public void setWays(List<Way> ways)
    {
        this.ways = new ArrayList<>();
        this.addWays(ways);
    }

    public List<Way> getWays()
    {
        return ways;
    }

    public void addWays(List<Way> ways)
    {
        for (int i=0; i < ways.size(); i++)
        {
            this.addWay(ways.get(i));
        }
    }

    public void addWay(Way newWay)
    {
        if (this.ways.isEmpty() && newWay.getCity().getWays().isEmpty())
            this.ways.add(newWay);
        else
        {
            for (int i=0; i < ways.size(); i++) // проверка на схожие пути в этом городе
            {
                if (this.ways.get(i).getCity() == newWay.getCity())
                    throw new IllegalArgumentException("Can't be two different ways to the " + newWay.getCity().title + "-city");
            }
            for (int i=0; i < newWay.getCity().getWays().size(); i++) // проверка на схожие пути из другого города в этот
            {
                Way tmpWay = newWay.getCity().getWays().get(i);
                if (tmpWay.getCity() == this && tmpWay.getCost() != newWay.getCost()) //без проверки на цену не сможем добавлять существующие пути, которые есть в добавленном городе, но нет в этом
                    throw new IllegalArgumentException("Can't be two different ways to the " + newWay.getCity().title + "-city");
            }
            this.ways.add(newWay);
        }
    }

    public void removeWay(Way deletWay)
    {
        if (this.ways.contains(deletWay))
        {
            this.ways.remove(deletWay);
        }

        for (int i=0; i < deletWay.getCity().getWays().size(); i++)
        {
            Way tmpWay = deletWay.getCity().getWays().get(i);

            if (tmpWay.getCity() == this)
                deletWay.getCity().removeWay(tmpWay);
        }
    }

    public String toString()
    {
        String res = title + "-ways: ";
        res += ways.toString();
        return res;
    }
}
