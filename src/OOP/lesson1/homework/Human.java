package OOP.lesson1.homework;

public class Human
{
    public String name;
    private int height;

    private static int averageHeight = 45; // average height (sm) of human while their borning


    public Human(String name, int height)
    {
        this.name = name;
        if (height < averageHeight)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public void set_height(int height)
    {
        if (height < averageHeight)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public int get_height()
    {
        return height;
    }

    public String showHuman()
    {
        return this.name + ", height = " + this.height;
    }
}
