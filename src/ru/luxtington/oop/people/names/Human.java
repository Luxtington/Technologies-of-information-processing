package ru.luxtington.oop.people.names;

public class Human
{
    private FullName fullName;
    private int height;
    private final Human father;

    public Human(FullName fullName, int height, Human father)
    {
        this.fullName = fullName;
        this.setHeight(height);
        this.father = father;
    }

    public Human(String name, int height)
    {
        this(new FullName(name, null, null), height, null);
    }

    public Human(String name, int height, Human father)
    {
        this(new FullName(name, null ,null), height, father);
    }

    public Human(FullName fullName, int height)
    {
        this(fullName, height, null);
    }

    public void setHeight(int height)
    {
        if (height < 0 || height > 500)
            throw new IllegalArgumentException("Incorrect height of human");
        this.height = height;
    }

    public int getHeight()
    {
        return height;
    }

    public FullName getFullName()
    {
        return new FullName(fullName.getName(), fullName.getSurname(), fullName.getPatronymic());
    }

    public Human getFather()
    {
        return new Human(father.getFullName(), father.getHeight(), father.getFather());
    }

    public String toString()
    {
        return fullName + ", height = " + height;
    }
}
