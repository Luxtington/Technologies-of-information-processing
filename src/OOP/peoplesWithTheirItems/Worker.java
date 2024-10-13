package OOP.peoplesWithTheirItems;

import java.util.ArrayList;
import java.util.List;

public class Worker
{
    private String surname;
    public Department department;

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
        if (this.department != null)
        {
            if (this.department.getChief() == this)
                throw new IllegalArgumentException("Chief of " + this.department.getTitle() + " can't work in " + department.getTitle() + " department");
        }
        this.department = department;
        this.department.addWorker(this);
    }

    public String showAllWorkers()
    {
        String res = "";
        for (int i = 0; i<department.getCurrCountWorkers(); i++)
        {
            List<Worker> workers = department.getListWorkers();
            res+=workers.get(i).getSurname();
            res+=" ";
        }
        return res;
    }

    public String toString()
    {
        if (department == null)
            return surname + " doesn't work in someone department";
        if (department.getChief() == this)
            return surname + " is the chief of " + department.getTitle() + " department";
        return surname + " works in " + department;
    }
}
