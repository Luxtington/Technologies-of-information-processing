package OOP.lesson3.homework;

public class Department
{
    public String title;
    public Worker chief;

    public Worker [] workers = new Worker[15];
    public int countWorkers = 0;

    public Department(String title, Worker chief)
    {
        this.title = title;
        this.chief = chief;
    }

    public String toString()
    {
        if (chief == null)
            return title + " department without chief";
        return title + " department, his chief " + chief.surname;
    }
}
