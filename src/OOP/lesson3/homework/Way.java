package OOP.lesson3.homework;

public class Way
{
    public City city;
    public  int cost;

    public Way(City city, int cost)
    {
        this.city = city;
        this.cost = cost;
    }

    public String toString()
    {
        return city.title + ": " + cost;
    }
}
