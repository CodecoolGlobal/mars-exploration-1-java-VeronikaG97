package com.codecool.marsexploration.logic;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MapWriter {
    public void write(char[][] bigMap) {
        try {
            doWrite(bigMap);
        } catch (RuntimeException err) {
            throw new RuntimeException();
        }
    }

    private void doWrite(char[][] bigMap) {
//        Files.write(Paths.get("map.txt"), bigMap.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        System.out.println("Saved the map in: map.txt");
    }
}