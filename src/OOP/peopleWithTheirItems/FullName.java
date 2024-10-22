package OOP.peopleWithTheirItems;

public class FullName
{
    private String surname;
    private final String name;
    private String patronymic;

    public FullName(String name, String surname, String patronymic)
    {
        String copyName = (name == null)? "" : name;
        String copySurname = (surname == null)? "" : surname;
        String copyPatronymic = (patronymic == null)? "" : patronymic;

        if (!((!(copyName.isBlank())) || (!(copySurname.isBlank())) || (!(copyPatronymic.isBlank())))) // at least 1 point in conditions
            throw new IllegalArgumentException("At least 1 parameter of FullName must not be empty");

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public FullName(String name, String surname)
    {
        this(name, surname, null);
    }

    public FullName(String name)
    {
        this(name, null, null);
    }

    public String getName()
    {
        return name;
    }

    public void setSurname(String surname)
    {
        String copySurname = (surname == null)? "" : surname;
        if (!(copySurname.isBlank())) this.surname = name;
    }

    public void setPatronymic(String patronymic)
    {
        String copyPatronymic = (surname == null)? "" : surname;
        if (!(copyPatronymic.isBlank())) this.surname = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getPatronymic()
    {
        return patronymic;
    }


    public String toString()
    {
        String copySurname = (surname == null)? "" : surname;
        String copyName = (name == null)? "" : name;
        String copyPatronymic = (patronymic == null)? "" : patronymic;
        return copySurname + " " + copyName + " " + copyPatronymic;
    }
}
