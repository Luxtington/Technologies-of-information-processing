package OOP.lesson2.homework;

public class Human
{
    public FullName fullName;
    private int height;


    public Human(FullName fullName, int height)
    {
        this.fullName = fullName;
        if (height < 0)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public void setHeight(int height)  // for task with the height
    {
        if (height < 0)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public String toString()
    {
        return fullName + ", height = " + height;
    }
}
