package ru.luxtington.main.tmp;

public interface Testable {
    String getData();
    Integer getNum();
    String concatenate(String s, Integer n);
    String concatenate(String n1, String n2, String n3);
    void setData(String data);
    int getOriginalMethodsCalls();
    int summOneAndTwo();
}
