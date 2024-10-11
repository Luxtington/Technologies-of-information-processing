package OOP.basicLessons.lesson1_4.homework;


public class Human
{
    public FullName fullName;
    private int height;
    public Human father;

    public Human(FullName fullName, int height, Human father)
    {
        this.fullName = fullName;
        if (height < 0)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public Human(String name, int height)
    {
        this(new FullName(name, null, null), height, null);
    }

    public void setHeight(int height)
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
