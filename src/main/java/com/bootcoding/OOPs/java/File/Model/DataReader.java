package com.bootcoding.OOPs.java.File.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    public static void main(String[] args) {
        File file = new File("src/main/resources/housing_price_dataset.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<FileInfo> houses = new ArrayList<>();
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                FileInfo fileInfo = buildHouse(line);
                houses.add(fileInfo);
            }
            System.out.println("Total Number of Houses :" + houses.size());

            List<FileInfo> houses2bhk = new ArrayList<>();
            for (FileInfo house : houses) {
                if (house.bedrooms == 2) {
                    houses2bhk.add(house);
                }
            }
            dataWrite(houses2bhk);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    private static void dataWrite(List<FileInfo> houses2bhk) {
        File file = new File("src/main/resources/2bhk.csv");
        StringBuffer sb = new StringBuffer();
        for (FileInfo house : houses2bhk) {
            String line = toCsv(house);
            sb.append(line);
            sb.append("\n");
        }
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(sb.toString());
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String toCsv(FileInfo house) {
        return house.getSquareFeet()
                + "," + house.bedrooms
                + "," + house.bathrooms
                + "," + house.neighbourhood
                + "," + house.year
                + "," + house.price;
    }

    private static FileInfo buildHouse(String line) {
            String[] tokens = line.split(",");
            return FileInfo.builder()
                    .squareFeet(Integer.parseInt(tokens[0]))
                    .bedrooms(Integer.parseInt(tokens[1]))
                    .bathrooms(Integer.parseInt(tokens[2]))
                    .neighbourhood(tokens[3])
                    .year(Integer.parseInt(tokens[4]))
                    .price(Double.parseDouble(tokens[5]))
                    .build();
        }
}

