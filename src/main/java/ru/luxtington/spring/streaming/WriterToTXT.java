package ru.luxtington.spring.streaming;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterToTXT implements Writeable{
    @Override
    public void writToFile(File file, List<String> data) throws IOException {
        Files.write(file.toPath(), data);
    }
}
