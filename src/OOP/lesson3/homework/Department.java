package OOP.lesson3.homework;

public class Department
{
    public String title;
    public Worker chief;

    private int maxQuantityWorkers = 1;
    public Worker [] workers = new Worker[maxQuantityWorkers];
    public int currCountWorkers = 0;

    public Department(String title, Worker chief)
    {
        this.title = title;
        this.chief = chief;
    }

    private Worker[] extendWorkers(Worker [] workers)
    {
        maxQuantityWorkers *= 2;
        Worker [] newWorkers = new Worker[maxQuantityWorkers];

        for (int i=0; i<workers.length; i++)
            newWorkers[i] = workers[i];

        return newWorkers;
    }

    public void addWorker(Worker worker)
    {
        if (currCountWorkers == maxQuantityWorkers)
            workers = extendWorkers(workers);

        workers[currCountWorkers++] = worker;
    }

    public String toString()
    {
        if (chief == null)
            return title + " department without chief";
        return title + " department, his chief " + chief.surname;
    }
}
