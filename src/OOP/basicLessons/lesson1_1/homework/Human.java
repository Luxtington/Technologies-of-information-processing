package OOP.basicLessons.lesson1_1.homework;

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

    public void setHeight(int height)
    {
        if (height < averageHeight)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public String toString()
    {
        return this.name + ", height = " + this.height;
    }
}
