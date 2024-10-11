package OOP.basicLessons.lesson1_2.homework;

public class Department
{
    public String title;
    public Worker chief;

    public Department(String title)
    {
        this.title = title;
    }

    public String toString()
    {
        if (chief == null) return title + " department without chief";
        return title + " department, his chief " + chief.surname;
    }
}
