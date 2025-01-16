package ru.luxtington.oop.different.items.sql;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Sql {
    private List<String> records;

    public Sql(@NotNull List<String> records) {
        this.records = new ArrayList<>(records);
    }

    public void addRecord(@NotNull String record){
        records.add(record);
    }

    public void removeRecord(@NotNull String record){
        if (!(records.contains(record)))
            throw new NoSuchElementException("There is no deleted record");

        records.remove(record);
    }

    public <T> T get(int index, Class<T> cl){
        return (T)records.get(index);
    }

    public String toString(){
        StringBuilder res = new StringBuilder("All records: " + System.lineSeparator());

        for (String r : records)
            res.append(r + " ");

        return res.toString();
    }
}
