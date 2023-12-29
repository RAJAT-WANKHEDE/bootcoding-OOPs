package com.bootcoding.OOPs.java.Project.processor;

import com.bootcoding.OOPs.java.Project.model.House;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BedroomProcessor {
    public List<House> getHouse(List<House> houses , int bedroomSize){
        List<House> bhkList = houses.stream().filter(h -> h.getBedrooms() == bedroomSize).
                collect(Collectors.toList());
        Collections.sort(bhkList);
        return bhkList;
    }
}
