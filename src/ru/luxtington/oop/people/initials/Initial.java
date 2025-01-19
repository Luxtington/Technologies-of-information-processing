package ru.luxtington.oop.people.initials;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Initial{
    String surname;
    String name;
    final String patronymic;
    private static Map<Integer, Initial> initials = new HashMap<>();

    private Initial(String name, String surname, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public static Initial of(@NotNull String surname, @NotNull String name, @NotNull String patronymic){
        if (initials.containsKey(Objects.hash(surname, name, patronymic)))
            return initials.get(Objects.hash(surname, name, patronymic));
        Initial newName = new Initial(surname, name, patronymic);
        initials.put(Objects.hash(surname, name, patronymic), newName);
        return newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String toString() {
        return "Initials: " + surname + " " + name + " " + patronymic;
    }
}
