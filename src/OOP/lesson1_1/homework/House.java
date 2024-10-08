package OOP.lesson1.homework;

public class House
{
    private int quanityFloors;

    public House(int quanityFloors)
    {
        if (quanityFloors < 1) throw new IllegalArgumentException("Incorect value of floors");
        this.quanityFloors = quanityFloors;
    }

    public void setQuanityFloors(int quanityFloors)
    {
        if (quanityFloors < 1) throw new IllegalArgumentException("Incorect value of floors");
        this.quanityFloors = quanityFloors;
    }

    public int getQuanityFloors()
    {
        return quanityFloors;
    }

    public String toString()
    {
        String wordFloor = (quanityFloors % 10 == 1) ? " этажом" : " этажами";
        return "Дом с " + quanityFloors + wordFloor;
    }
}
