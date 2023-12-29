package com.bootcoding.OOPs.java.Project.report;

import com.bootcoding.OOPs.java.Project.reader.file.FileReader;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter implements IFileWriter{
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void write(List data) {

    }

    @Override
    public void write(List data, String outputPath) {
        try {
            String s = objectMapper.writeValueAsString(data);
            FileWriter fw = new FileWriter(new File(outputPath));
            fw.write(s);
            fw.flush();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
