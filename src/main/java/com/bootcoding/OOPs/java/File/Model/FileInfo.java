package com.bootcoding.OOPs.java.File.Model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileInfo {
    int squareFeet;
    int bedrooms;
    int bathrooms;
    String neighbourhood;
    int year;
    double price;

}
