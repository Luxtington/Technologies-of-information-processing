package OOP.lesson2.homework;

public class FullName
{
    public String surname;
    public String name;
    public String patronymic;

    public String toString()
    {
        String copySurname = (surname == null)? "" : surname;
        String copyName = (name == null)? "" : name;
        String copyPatronymic = (patronymic == null)? "" : patronymic;
        return copySurname + " " + copyName + " " + copyPatronymic;
    }
}
