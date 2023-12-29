package com.bootcoding.OOPs.java.Project;

import com.bootcoding.OOPs.java.Project.processor.BedroomProcessor;
import com.bootcoding.OOPs.java.Project.reader.file.FileReader;
import com.bootcoding.OOPs.java.Project.reader.file.csv.CsvFileReader;
import com.bootcoding.OOPs.java.Project.report.CsvFileWriter;
import com.bootcoding.OOPs.java.Project.report.IFileWriter;
import com.bootcoding.OOPs.java.Project.report.JsonFileWriter;

import java.util.List;

public class FileApp {
    public static void main(String[] args) {


        // 1 read data from File

        FileReader fileReader = new CsvFileReader("src/main/resources/housing_price_dataset.csv");
        BedroomProcessor bp = new BedroomProcessor();
        IFileWriter fw = new CsvFileWriter();

        IFileWriter jsonWriter = new JsonFileWriter();

        List data = fileReader.read();
        fw.write(bp.getHouse(data, 2), "src/main/resources/2bhk.csv");
        fw.write(bp.getHouse(data, 3), "src/main/resources/3bhk.csv");
        fw.write(bp.getHouse(data, 4), "src/main/resources/4bhk.csv");
        fw.write(bp.getHouse(data, 5), "src/main/resources/5bhk.csv");


        jsonWriter.write(bp.getHouse(data, 2), "src/main/resources/2bhk.json");

    }
}