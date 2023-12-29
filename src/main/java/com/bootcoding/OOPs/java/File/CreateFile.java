package com.bootcoding.OOPs.java.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File newFile = new File("Raj.txt");
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileWriter myFile = new FileWriter(newFile);
            myFile.write("I am new here\nI am learning Java");
            myFile.flush();
            //myFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
