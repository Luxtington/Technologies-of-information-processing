package ru.luxtington.spring.streaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderFromTXT implements Readable{

    @Override
    public List<String> readFromSource(File file) throws IOException {
        return Files.readAllLines(Paths.get(file.getAbsolutePath()));
    }
}
