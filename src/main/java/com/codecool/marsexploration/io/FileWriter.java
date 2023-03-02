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
            for (int i1 = 0; i1 < finalBigMap[0].length; i1++) {
                fileWriter.write(finalBigMap[i][i1]);
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
      //CODE REVIEW QUESTION HOW TO WRITE A FILE WITH StandardOpenOption
       /* Files.write(Paths.get("src/main/resources/map.txt"),
                finishedMap.getBytes(),
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        );*/
        System.out.println("Saved the map in: MarsMap.txt");
    }

}
