package com.codecool.marsexploration.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileWriter {
    public void write(char[][] finalBigMap){
        try {
            doWrite(finalBigMap);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void doWrite(char[][] finalBigMap) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new java.io.FileWriter("src/main/resources/MarsMap.txt"));
        for (int i = 0; i < finalBigMap.length; i++) {
            for (int j = 0; j < finalBigMap[0].length; j++) {
                fileWriter.write(finalBigMap[i][j]);
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
        System.out.println("Saved the map in: MarsMap.txt");
    }

}
