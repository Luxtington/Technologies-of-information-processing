package OOP.lesson2.homework;

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
    }

    public String toString()
    {
        if (surname == department.chief.surname)
            return surname + " is the chief of " + department.title + " department";
        return surname + " works in " + department.title + " department, his chief is " + department.chief.surname;
    }
}
