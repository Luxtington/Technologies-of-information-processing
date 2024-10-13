package OOP.differentThings;

import java.util.List;
import java.util.ArrayList;

public class City
{
    public String title;
    public List<Way> ways = new ArrayList<>();
    private static int cityNumber; // for comfortable print in Main

    {
        cityNumber++;
    }

    public City(String title, List<Way> ways)
    {
        this.title = title;
        setWays(ways);
    }

    public City(String title)
    {
        this(title, new ArrayList<>());
    }

    public static int getCityNumber()
    {
        return cityNumber;
    }

    public void setWays(List<Way> ways)
    {
        for (int i=0; i < ways.size(); i++)
        {
            this.setWay(ways.get(i));
        }
    }

    public void setWay(Way way)
    {
        if (ways.size() == 0)
            ways.add(way);
        else
        {
            for (int i=0; i < ways.size(); i++)
            {
                if (ways.get(i).city == way.city)
                    throw new IllegalArgumentException("Cannot be two  same ways to the " + way.city.title + "-city");

            }
            ways.add(way);
        }

    }

    public void removeWay(Way way)
    {
        ways.remove(way);
    }

    public String toString()
    {
        String res = title + "-ways: ";
        res += ways.toString();
        return res;
    }
}
