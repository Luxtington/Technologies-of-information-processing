package ru.luxtington.oop.people.university;

public final class Teacher extends Person{
    final String name;
    final int numberCard;
    final String post;

    public Teacher(String name, int numberCard, String post) {
        this.name = name;
        this.numberCard = numberCard;
        this.post = post;
    }

    @Override
    public boolean canIGo() {
        String tmpPost = post == null ? "" : post;
        String tmpName = name == null ? "" : name;
        return (!tmpName.isBlank()) && ((numberCard > 0) || (!tmpPost.isBlank()));
    }

    public String getName() {
        return name;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public String getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "Teacher: " + name + ", " + numberCard + ", " + post;
    }
}
