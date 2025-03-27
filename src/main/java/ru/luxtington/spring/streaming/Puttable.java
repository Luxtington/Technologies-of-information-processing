package ru.luxtington.spring.streaming;

import java.util.List;

public interface Puttable {
    List<String> putToFile(List<String> data);
}
