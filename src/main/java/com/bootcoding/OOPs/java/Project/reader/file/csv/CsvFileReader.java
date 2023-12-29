package com.bootcoding.OOPs.java.Project.reader.file.csv;

import com.bootcoding.OOPs.java.Project.model.House;
import com.bootcoding.OOPs.java.Project.reader.file.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {
    private String path;
    public CsvFileReader(String inputFilePath){
        this.path = inputFilePath;
    }

    @Override
    public List read() {
        File file = new File(path);

        try {
            BufferedReader bReader = new BufferedReader(new java.io.FileReader(file));
            String line = bReader.readLine();
            List<House> houses = new ArrayList<>();
            while ((line = bReader.readLine()) != null){
                House house = buildHouse(line);
                houses.add(house);
            }
            return  houses;
        }catch (Exception e){
            e.printStackTrace();
        }
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
