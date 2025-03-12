package ru.luxtington.reflection.base.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ObjectsWriter<T> {
    private final String fileName;

    public ObjectsWriter(String fileName) {
        this.fileName = fileName;
    }

    public void writeObjectsToFile(List<T> objects) throws IOException {
        File f = new File(fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            for (T o : objects) {
                bw.write(o.toString());
                bw.newLine();
            }
        }
    }
}
