package ru.luxtington.spring.streaming;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Writeable {
    void writToFile(File file, List<String> data) throws IOException;
}
