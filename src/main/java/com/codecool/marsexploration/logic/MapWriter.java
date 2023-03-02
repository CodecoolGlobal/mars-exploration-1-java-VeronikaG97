package com.codecool.marsexploration.logic;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WriteMap {
    public void write(bigMap){
        try {
            return doWrite(bigMap);
        } catch (RuntimeException err){

        }
    }

    private void doWrite(bigMap) {
        Files.write(Paths.get("map.txt"), bigMap.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        System.out.println("Saved the map in: map.txt");
    }
}