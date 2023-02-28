package com.codecool.marsexploration.logic.MountainMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;

import java.util.Arrays;
import java.util.Random;

public class GenerateRandomMap {
private final char[][]definedMap;
private final Terrains terrain;
private final Resources resource;

    public GenerateRandomMap(char[][] definedMap, Terrains terrain, Resources resource) {
        this.definedMap=definedMap;
        this.terrain=terrain;
        this.resource=resource;
    }

    public char[][] generateMap() {

        //Or maybe a record
        for(int i = 0; i < definedMap.length; i++) {
            int randomIndex = new Random().nextInt(definedMap.length);
            for(int j=0; j<definedMap[i].length; j++) {
                definedMap[i][randomIndex]= terrain.getTerrain();
            }
        }
       Arrays.stream(definedMap).forEach(System.out::println);
        return definedMap;
    }
    }


