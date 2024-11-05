package oop.basicLessons.lesson1_3.homework;

public class Department
{
    public String title;
    public Worker chief;

    private int maxQuantityWorkers = 1;
    private Worker [] workers = new Worker[maxQuantityWorkers];
    private int currCountWorkers = 0;

    public Department(String title, Worker chief)
    {
        this.title = title;
        this.chief = chief;
    }

    public Worker[] getListWorkers()
    {
        Worker [] newWorkers = new Worker[currCountWorkers];
        for (int i=0; i<currCountWorkers; i++)
            newWorkers[i] = workers[i];

        return newWorkers;
    }

    public int getMaxQuantityWorkers()
    {
        return maxQuantityWorkers;
    }

    public int getCurrCountWorkers()
    {
        return currCountWorkers;
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
