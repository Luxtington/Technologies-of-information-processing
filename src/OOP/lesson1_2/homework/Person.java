package OOP.lesson1_2.homework;

public class Person
{
    public FullName fullName;
    public Person father;

    public Person(FullName fullName, Person father)
    {
        this.fullName = fullName;
        this.father = father;
    }

    public Person(FullName fullName)
    {
        this.fullName = fullName;
    }

    private Person()
    {
        // just for creating copyFather in this toString-method
    }

    public String getFatherSurname()
    {
        if (father == null) return ""; // father's name wasn't found
        else if (father.fullName.surname != null) return father.fullName.surname;
        return father.getFatherSurname();
    }

    public FullName getFullName()
    {
        return fullName;
    }

    public String toString()
    {
        if (father == null)
            return fullName + "";

        FullName copyFullName = new FullName(); // for recording the available data
        copyFullName.surname = (fullName.surname == null) ? null : fullName.surname;
        copyFullName.name = (fullName.name == null) ? null : fullName.name;
        copyFullName.patronymic = (fullName.patronymic == null) ? null : fullName.patronymic;

        if (fullName.surname == null)
            copyFullName.surname = getFatherSurname();


        if (fullName.patronymic == null && father.fullName.name != null)
            copyFullName.patronymic = father.fullName.name + "ovich";
        else copyFullName.patronymic = "";

        return copyFullName.toString();
    }
}
