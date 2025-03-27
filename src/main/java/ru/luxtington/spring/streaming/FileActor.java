package ru.luxtington.spring.streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileActor {
    private String inputFileName;
    private String outputFileName;
    private Readable reader;
    private Writeable writer;
    private List<Puttable> actionsWithData;

    @Autowired
    public FileActor(@Qualifier("beanSourceFile") String inputFileName,
                     @Qualifier("beanOutputFile") String outputFileName,
                     Readable reader,
                     Writeable writer,
                     List<Puttable> actionsWithData) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.reader = reader;
        this.writer = writer;
        this.actionsWithData = actionsWithData;
    }

    public void doActionsWithFile() throws Exception {
        File input = new File(inputFileName);
        File output = new File(outputFileName);

        List<String> res = reader.readFromSource(input);
        for (Puttable p : actionsWithData){
            res = p.putToFile(res);
        }
        writer.writToFile(output, res);
    }
}
