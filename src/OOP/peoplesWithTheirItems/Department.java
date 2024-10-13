package OOP.peoplesWithTheirItems;

import java.util.ArrayList;
import java.util.List;

public class Department
{
    private String title;
    private Worker chief;

    private List<Worker> workers = new ArrayList<Worker>();

    public Department(String title, Worker chief)
    {
        this.title = title;
        this.setChief(chief);
    }

    public void setChief(Worker chief)
    {
        if (chief.department == null || chief.department == this)
            this.chief = chief;
        else
            throw new IllegalArgumentException("Worker can't work in different departments");
    }

    public Worker getChief()
    {
        return chief;
    }

    public String getTitle()
    {
        return title;
    }

    public List<Worker> getListWorkers()
    {
        List<Worker> newWorkers = new ArrayList<Worker>();
        for (int i=0; i < workers.size(); i++)
            newWorkers.set(i, workers.get(i));
        return newWorkers;
    }

    public int getCurrCountWorkers()
    {
        return workers.size();
    }

    public void addWorker(Worker worker)
    {
        if (worker.department.getChief() == worker && worker !=chief)
        {
            throw new IllegalArgumentException(worker.getSurname() + " can't work in " + this.title + ", cause he's the cheif of " + worker.department + " department");
        }
        workers.add(worker);
    }

    public String toString()
    {
        if (chief == null)
            return title + " department without chief";
        return title + " department, his chief " + chief.getSurname();
    }
}
