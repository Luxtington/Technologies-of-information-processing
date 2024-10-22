package OOP.differentThings;

public class Way
{
    private City city;
    private int cost;

    public Way(City city, int cost)
    {
        this.city = city;
        if (cost < 0) throw new IllegalArgumentException("Incorrect value of cost, it should be greater/equal than 0");
        this.cost = cost;
    }

    public City getCity()
    {
        return city;
    }

    public int getCost()
    {
        return cost;
    }

    public String toString()
    {
        return city.getTitle() + ": " + cost;
    }
}
