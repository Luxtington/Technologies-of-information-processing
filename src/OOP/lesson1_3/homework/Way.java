package OOP.lesson1_3.homework;

public class Way
{
    public City city;
    public  int cost;

    public Way(City city, int cost)
    {
        this.city = city;
        if (cost < 0) throw new IllegalArgumentException("Incorrect value of cost, it should be greater/equal than 0");
        this.cost = cost;
    }

    public String toString()
    {
        return city.title + ": " + cost;
    }
}
