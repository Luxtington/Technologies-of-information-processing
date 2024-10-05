package OOP.lesson3.homework;

public class City
{
    public String title;
    public Way [] ways;
    public static int cityNumber;

    {
        cityNumber++;
    }

    public City(String title)
    {
        this.title = title;
    }

    public void setWays(Way [] ways)
    {
        this.ways = ways;
    }

    public String toString()
    {
        String res = title + "-ways: [ ";
        for (int i=0; i<ways.length; i++)
        {
            res+=ways[i];
            if (i < ways.length-1)
                res+=", ";
            else
                res+=" ]";
        }
        return res;
    }
}
