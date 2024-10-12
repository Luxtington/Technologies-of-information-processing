package OOP.peoplesWithTheirItems;

public class FullName
{
    private final String surname;
    private final String name;
    private final String patronymic;

    public FullName(String name, String surname, String patronymic)
    {
        (name.isBlank() || surname.isBlank() || patronymic.isBlank());

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


    public String toString()
    {
        String copySurname = (surname == null)? "" : surname;
        String copyName = (name == null)? "" : name;
        String copyPatronymic = (patronymic == null)? "" : patronymic;
        return copySurname + " " + copyName + " " + copyPatronymic;
    }
}
