package OOP.peopleWithTheirItems;

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

    public void setChief(Worker newChief)
    {
        if (this.chief == newChief) return;
        if (newChief == null)
        {
            this.chief = null;
            return;
        }
        this.addWorker(newChief);
        this.chief = newChief;
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

    public void addWorker(Worker newWorker)
    {
        if (workers.contains(newWorker)) return;

        if (newWorker.getDepartment() != null)
        {
            if (newWorker.getDepartment().getChief() == newWorker)
                newWorker.getDepartment().setChief(null);
            newWorker.getDepartment().removeWorker(newWorker);
        }

        this.workers.add(newWorker);
        newWorker.setDepartment(this);
    }

    public void removeWorker(Worker worker)
    {
        if (workers.contains(worker))
        {
            workers.remove(worker);

            if (this.chief == worker)
                this.chief = null;

            worker.setDepartment(null);
        }
    }

    public String toString()
    {
        if (chief == null)
            return title + " department without chief";
        return title + " department, his chief " + chief.getSurname();
    }
}
