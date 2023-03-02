package com.codecool.marsexploration.logic.MountainMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MountainMapGenerator implements CreateMap{
    public char[][] createMountainsMap(String size) {
        char[][] small = new char[4][4];
        char[][] medium = new char[20][20];
        char[][] large = new char[30][30];
        switch (size) {
            case "small":
                return createARandomMap(small, Terrains.MOUNTAIN, Resources.MINERALS);
            case "medium":
                return createARandomMap(medium, Terrains.MOUNTAIN, Resources.MINERALS);
            case "large":
                return createARandomMap(large, Terrains.MOUNTAIN, Resources.MINERALS);
            default:
                System.out.println("Size does not exist");
        }
        char[][] map = new char[0][0];
        return map;
    }

    @Override
    public char[][] createARandomMap(char[][] size, Terrains terrains, Resources resources) {
        GenerateRandomMap generateRandomMap = new GenerateRandomMap(size, terrains, resources);

        generateRandomMap.initialize();
        char[][] map = generateRandomMap.generateMap();

        while (checkIfMapIsEmpty(map)) {
            map = generateRandomMap.generateMap();
            break;
        }
        char[][] finalMapOfMountains = deleteEmptyRows(map);
        return finalMapOfMountains;
    }

    private char[][] deleteEmptyRows(char[][] map) {
        System.out.println(map.length+ "Length of map");
        List<char[]> mapList=  Arrays.stream(map).filter(row -> isEmptyRow(row)).collect(Collectors.toList());
        char[][] newMap = mapList.toArray(new char[][]{});
       return newMap;

    }
    private boolean isEmptyRow(char[] row) {
        for (char c : row) {
           char targetCharacter = ' ';
           if(c != targetCharacter){
               return true;
           }
        }
        return false;
    }

    private boolean checkIfMapIsEmpty(char[][] map) {
        boolean notNull = true;
        for (char[] array : map) {
            for (char c : array) {
                if (c != ' ') {
                    notNull = false;
                    break;
                }
            }
        }
        return notNull;
    }
}
