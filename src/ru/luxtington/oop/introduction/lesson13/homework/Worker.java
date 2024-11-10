package ru.luxtington.oop.introduction.lesson13.homework;

public class Worker
{
    public String surname;
    public Department department;

    public Worker(String surname)
    {
        this.surname = surname;
    }

    public void setDepartment(Department department)
    {
        this.department = department;
        this.department.addWorker(this);
    }

    public String showAllWorkers()
    {
        String res = "";
        for (int i = 0; i<department.getCurrCountWorkers(); i++)
        {
            Worker [] workers = department.getListWorkers();
            res+=workers[i].surname;
            res+=" ";
        }
        return res;
    }

    public String toString()
    {
        if (department == null)
            return surname + " doesn't work in someone department";
        if (department.chief == this)
            return surname + " is the chief of " + department.title + " department";
        return surname + " works in " + department;
    }
}
