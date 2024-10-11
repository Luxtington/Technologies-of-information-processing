package OOP.peoplesWithTheirItems;

public class Person
{
    private int height;
    public FullName fullName;
    public Person father;

    public Person(FullName fullName, int height, Person father)
    {
        if (height<0)
            throw new IllegalArgumentException("Incorrect value of height");
        this.height = height;

        this.fullName = fullName;
        this.father = father;
    }

    public Person(String name, int height)
    {
        this(new FullName(name, null ,null), height, null);
    }

    public Person(String name, int height, Person father)
    {
        this(new FullName(name, null ,null), height, father);
    }

    public Person(FullName fullName, int height)
    {
        this(fullName, height, null);
    }


    public int getHeight(){return height;}

    public void setHeight(int height)
    {
        if (height<0) throw new IllegalArgumentException("Incorrect value of height");
        this.height = height;
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

        FullName copyFullName = new FullName(null ,null ,null);
        copyFullName.surname = (fullName.surname == null) ? null : fullName.surname;
        copyFullName.name = (fullName.name == null) ? null : fullName.name;
        copyFullName.patronymic = (fullName.patronymic == null) ? null : fullName.patronymic;

        if (fullName.surname == null)
            copyFullName.surname = getFatherSurname();


        if (fullName.patronymic == null && father.fullName.name != null)
            copyFullName.patronymic = father.fullName.name + "ovich";
        else copyFullName.patronymic = "";

        return copyFullName.toString() + ", height = " + height;
    }
}
