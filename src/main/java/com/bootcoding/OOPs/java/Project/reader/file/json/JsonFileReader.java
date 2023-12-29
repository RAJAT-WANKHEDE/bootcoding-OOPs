package com.bootcoding.OOPs.java.Project.reader.file.json;

import com.bootcoding.OOPs.java.File.Model.FileInfo;
import com.bootcoding.OOPs.java.Project.model.House;
import com.bootcoding.OOPs.java.Project.reader.file.FileReader;

import java.io.File;
import java.util.List;

public class JsonFileReader implements FileReader {
    private String path;
    public JsonFileReader(String inputFilePath){
        this.path = inputFilePath;
    }
    @Override
    public List read() {
        File file = new File(path);

        return null;
    }

    private static House buildHouse(String line) {
        String[] tokens = line.split(",");
        return House.builder()
                .squareFeet(Integer.parseInt(tokens[0]))
                .bedrooms(Integer.parseInt(tokens[1]))
                .bathrooms(Integer.parseInt(tokens[2]))
                .neighbourhood(tokens[3])
                .year(Integer.parseInt(tokens[4]))
                .price(Double.parseDouble(tokens[5]))
                .build();
    }
}
