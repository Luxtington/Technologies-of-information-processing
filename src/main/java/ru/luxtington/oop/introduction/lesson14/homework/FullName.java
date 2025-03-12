package ru.luxtington.oop.introduction.lesson14.homework;

public class FullName
{
    public String surname;
    public String name;
    public String patronymic;

    public FullName(String name, String surname, String patronymic)
    {
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
