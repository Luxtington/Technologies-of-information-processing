package OOP.basicLessons.lesson1_5.homework;

public class Cat
{
    public String name;

    public Cat(String name)
    {
        this.name = name;
    }

    public String makeMeow(int times)
    {
        String res = name + ": ";
        for (int i=0; i<times; i++)
        {
            res+="meow";
            if (i == times-1) res += "!";
            else res += ", ";
        }
        return res;
    }

    public String makeMeow()
    {
        return makeMeow(1);
    }

    public String toString()
    {
        return "Cat: " + name;
    }
}
