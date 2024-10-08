package OOP.lesson3.homework;

import java.util.Arrays;

public class City
{
    public String title;
    public Way [] ways;
    private static int cityNumber;

    {
        cityNumber++;
    }

    public City(String title)
    {
        this.title = title;
    }

    public static int getCityNumber()
    {
        return cityNumber;
    }

    public void setWays(Way [] ways)
    {
        this.ways = ways;
    }

    public String toString()
    {
        String res = title + "-ways: ";
        res += Arrays.toString(ways);
        return res;
    }
}
