package ru.luxtington.spring.streaming;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Readable {
    List<String> readFromSource(File file) throws IOException;
}
