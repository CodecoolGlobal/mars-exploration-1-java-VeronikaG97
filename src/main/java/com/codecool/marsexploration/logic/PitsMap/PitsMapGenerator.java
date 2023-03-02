package com.codecool.marsexploration.logic.PitsMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PitsMapGenerator implements CreateMap {

    public char[][] createPitsMap(String size) {
        char[][] small = new char[5][5];
        char[][] medium = new char[15][15];
        switch (size) {
            case "small":
                return createARandomMap(small, Terrains.PITS, Resources.WATER);
            case "medium":
                return createARandomMap(medium, Terrains.PITS, Resources.WATER);
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

        char[][] finalMapOfPits = deleteEmptyRows(map);
        return finalMapOfPits;
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
