package OOP.lesson1.homework;

public class FullName
{
    public String surname;
    public String name;
    public String patronymic;

    public FullName(String surname, String name, String patronymic)
    {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public FullName(String surname, String name)
    {
        this.surname = surname;
        this.name = name;
    }

    public FullName(String surname)
    {
        this.surname = surname;
    }

    public String toString()
    {
        String copySurname = (surname == null)? "" : surname;
        String copyName = (name == null)? "" : name;
        String copyPatronymic = (patronymic == null)? "" : patronymic;
        return copySurname + " " + copyName + " " + copyPatronymic;
    }
}
