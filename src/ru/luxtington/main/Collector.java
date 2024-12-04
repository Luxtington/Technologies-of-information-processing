package ru.luxtington.main;

import java.util.List;

public interface Collector <T>{
    List<T> groupData(List<T> objs);
}
