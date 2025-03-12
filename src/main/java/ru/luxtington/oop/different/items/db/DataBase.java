package ru.luxtington.oop.different.items.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataBase {

    private List<String> records = new ArrayList<>(Arrays.asList("as", "asl", "add", "sk", "lkr", "al", "kl", "aj", "kj", "kw"));
    protected final int maxConnectionCapacity;
    protected int currConnectionCapacity;

    public DataBase(int maxConnectionCapacity) {
        if (maxConnectionCapacity < 1)
            throw new IllegalArgumentException("Db's capacity can't be less than 1 element");
        this.maxConnectionCapacity = maxConnectionCapacity;
    }

    public int getMaxConnectionCapacity() {
        return maxConnectionCapacity;
    }

    public Connection getConnection(){
        if (currConnectionCapacity < maxConnectionCapacity){
            currConnectionCapacity++;
            return new Connection();
        }
        return null;
    }

    public class Connection{

        private Connection() {
        }

        public String getRecordFromDb(int index){
            return (index >= records.size()) ? null : records.get(index);
        }

        public void insertRecordIntoDb(String value){
            records.add(value);
        }

        public String toString(){
            return "This connection is referred to " + DataBase.this;
        }
    }

    public String toString(){
        return "DataBase № " + this.hashCode();
    }
}
