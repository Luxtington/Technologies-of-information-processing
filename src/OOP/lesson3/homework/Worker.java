package OOP.lesson3.homework;

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
        this.department.workers[this.department.countWorkers++] = this;
    }

    public String showColleagues()
    {
        String res = "";
        for (int i=0; i<department.countWorkers; i++)
        {
            res+=department.workers[i].surname;
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
