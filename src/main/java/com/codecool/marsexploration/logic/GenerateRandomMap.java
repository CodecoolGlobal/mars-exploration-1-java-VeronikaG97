package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;


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
        int RESOURCE_LIMIT=2;
        int TERRAIN_LIMIT = Math.round(definedMap.length/2 - 2);
        int countResources;
        int countTerrains;

        for (int i = 0; i < definedMap.length; i++) {
            countResources = 0;
            countTerrains=0;
            int indexOfEmptyRow = new Random().nextInt(definedMap.length);
            if (indexOfEmptyRow % 2 == 0) continue;

            for (int j = 0; j < definedMap[i].length; j++) {

                int indexOfEmptyColumn = new Random().nextInt(definedMap.length);
                if (j == indexOfEmptyColumn) continue;

                int randomIndex = new Random().nextInt(definedMap.length);

                if(countTerrains < TERRAIN_LIMIT) {
                    definedMap[i][randomIndex] = terrain.getTerrain();
                }
                countTerrains++;
                if(randomIndex+1 < definedMap[0].length && countResources < RESOURCE_LIMIT ) {
                    definedMap[i][randomIndex +1] = resource.getResources();
                    countResources++;
                }
            }
        }
        //Arrays.stream(definedMap).forEach(System.out::println);
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