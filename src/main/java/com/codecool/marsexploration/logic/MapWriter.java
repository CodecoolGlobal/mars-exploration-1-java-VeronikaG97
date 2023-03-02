package com.codecool.marsexploration.logic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class MapWriter {
    public void write(){
        String bigMap[][] = new String[2][2];
        bigMap[0][0] = "*";
        bigMap[0][1] = "#";
        bigMap[1][0] = "+";
        bigMap[1][1] = "~";
        try {
            doWrite(bigMap);
        } catch (RuntimeException | IOException err){
            System.out.println("Something went wrong with saving the map, we are working on it!");
        }
    }

    private void doWrite(String[][] bigMap) throws IOException {
        String finishedMap = Arrays.toString(bigMap);
        Files.write(Paths.get("src/main/resources/map.txt"),
                finishedMap.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        );
        System.out.println("Saved the map in: map.txt");
    }
}
