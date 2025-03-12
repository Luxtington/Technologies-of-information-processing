package ru.luxtington.oop.different.strange;

public abstract class Transformator {

    public final void transform(){
        String date = read("File");
        String newDate = map("data");
        write(newDate, "new file");
    }

    abstract public String read(String name);
    abstract public String map(String date);
    abstract public void write(String name, String file);
}
