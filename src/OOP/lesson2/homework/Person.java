package OOP.lesson2.homework;

public class Person
{
    public FullName fullName;
    public Person father;
    private String gender;

    public Person(FullName fullName, Person father, String gender)
    {
        if (!(gender == "male" || gender == "female"))
            throw new IllegalArgumentException("Incorrect name of gender");

        this.fullName = fullName;
        this.father = father;
        this.gender = gender;
    }

    public Person(FullName fullName, String gender)
    {
        if (!(gender == "male" || gender == "female"))
            throw new IllegalArgumentException("Incorrect name of gender");

        this.fullName = fullName;
        this.gender = gender;
    }

    public String getGender()
    {
        return gender;
    }

    public String toString()
    {
        if (father == null)
            return fullName + "";

        if (fullName.surname == null)
            fullName.surname = father.fullName.surname;

        if (fullName.patronymic == null) // !!! gender and ending
            fullName.patronymic = father.fullName.name + "ovich";

        return fullName + "";
    }

}
