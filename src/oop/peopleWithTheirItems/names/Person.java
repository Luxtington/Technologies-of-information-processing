package oop.peopleWithTheirItems.names;

public class Person
{
    private int height;
    public FullName fullName;
    public Person father;

    public Person(FullName fullName, int height, Person father)
    {
        this.setHeight(height);
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
        if (height<0)
            throw new IllegalArgumentException("Incorrect value of height");
        this.height = height;
    }

    public String getFatherSurname()
    {
        if (father == null) return ""; // father's name wasn't found
        else if (father.fullName.getSurname() != null) return father.fullName.getSurname();
        return father.getFatherSurname();
    }

    public FullName getFullName()
    {
        return fullName;
    }

    public String toString()
    {
        if (father == null) // there's no things to find
            return fullName + "";
        //FullName copyFullName = new FullName(null ,null ,null);

        String copyName = "", copySurname = "", copyPatronymic = "";
        if (fullName.getName() != null)
            copyName = fullName.getName();

        if (fullName.getSurname() != null)
            copySurname = fullName.getSurname();

        if (fullName.getPatronymic() != null)
            copyPatronymic = fullName.getPatronymic();

        //copyFullName.surname = (fullName.getSurname() == null) ? null : fullName.getSurname();
        //copyFullName.name = (fullName.getName() == null) ? null : fullName.getName();
        //copyFullName.patronymic = (fullName.getPatronymic() == null) ? null : fullName.getPatronymic();

        if (fullName.getSurname() == null)
            copySurname = getFatherSurname();


        if (fullName.getPatronymic() == null && father.fullName.getName() != null)
            copyPatronymic = father.fullName.getName() + "ovich";
        //else copyFullName.patronymic = "";

        return copyName + " " + copySurname +  " " + copyPatronymic + ", height = " + height;
    }
}
