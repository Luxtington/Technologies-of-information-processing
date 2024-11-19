package ru.luxtington.oop.people.departments;

import java.util.ArrayList;
import java.util.List;

public class Department
{
    String title;
    Worker chief;
    List<Worker> workers = new ArrayList<Worker>();

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
        return new ArrayList<>(workers);
    }

    public int getCurrCountWorkers()
    {
        return workers.size();
    }

    public void addWorker(Worker newWorker)
    {
        if (workers.contains(newWorker)) return;

        if (newWorker.department != null)
        {
            if (newWorker.department.chief == newWorker)
                newWorker.department.setChief(null);
            newWorker.department.removeWorker(newWorker);
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
        return title + " department, his chief " + chief.surname;
    }
}
