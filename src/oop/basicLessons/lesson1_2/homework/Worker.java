package oop.basicLessons.lesson1_2.homework;

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
        if (department == null)
            return surname + " doesn't work in someone department";
        if (department.chief == this)
            return surname + " is the chief of " + department.title + " department";
        return surname + " works in " + department;
    }
}
