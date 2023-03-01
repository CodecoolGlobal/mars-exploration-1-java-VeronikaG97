package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomMap {
    private char[][] definedMap;
    private final Terrains terrain;
    private final Resources resource;

    public GenerateRandomMap(char[][] definedMap, Terrains terrain, Resources resource) {
        this.definedMap = definedMap;
        this.terrain = terrain;
        this.resource = resource;
    }

    public char[][] generateMap() {

        //Or maybe a record
        for (int i = 0; i < definedMap.length; i++) {
            int randomIndexRow = new Random().nextInt(definedMap.length);
            if (randomIndexRow % 2 == 0) continue;

            for (int j = 0; j < definedMap[i].length; j++) {

                int neighbouringIndex = j == (definedMap[i].length - 1) ? j : j++;

                if (definedMap[i][neighbouringIndex] == ' ') {
                    definedMap[i][neighbouringIndex] = resource.getResources();
                }

                int randomIndexRow2 = new Random().nextInt(definedMap.length);
                if (j == randomIndexRow2) continue;

                int randomIndex = new Random().nextInt(definedMap.length);
                definedMap[i][randomIndex] = terrain.getTerrain();
            }
        }

        Arrays.stream(definedMap).forEach(System.out::println);
        System.out.println("END");
        return definedMap;
    }

    public void initialize() {
        for (int i = 0; i < definedMap.length; i++) {
            for (int j = 0; j < definedMap[i].length; j++) {
                definedMap[i][j] = ' ';
            }
        }
    }
}


