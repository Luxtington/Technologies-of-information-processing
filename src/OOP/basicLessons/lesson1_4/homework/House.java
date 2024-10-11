package OOP.basicLessons.lesson1_4.homework;

public class House
{
    final int quanityFloors;

    public House(int quanityFloors)
    {
        if (quanityFloors < 1) throw new IllegalArgumentException("Incorect value of floors");
        this.quanityFloors = quanityFloors;
    }

    public String toString()
    {
        String wordFloor = (quanityFloors % 10 == 1) ? " этажом" : " этажами";
        return "Дом с " + quanityFloors + wordFloor;
    }
}
