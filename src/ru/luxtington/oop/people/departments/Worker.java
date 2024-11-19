package ru.luxtington.oop.people.departments;

import java.util.ArrayList;
import java.util.List;

public class Worker
{
    String surname;
    Department department;

    public Worker(String surname)
    {
        this.surname = surname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setDepartment(Department department)
    {
        if (this.department == department) return;
        if (this.department != null)
        {
            if (this == this.department.chief)
            {
                this.department.setChief(null); // chief goes in another department
            }
            this.department.removeWorker(this);
        }
        if (department != null)
        {
            department.addWorker(this);
        }
        this.department = department;
    }

    public Department getDepartment()
    {
        return department;
    }

    public List<Worker> showAllWorkers()
    {
        return new ArrayList<>(this.department.workers);
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
