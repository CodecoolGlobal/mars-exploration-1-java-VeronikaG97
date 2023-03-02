package com.codecool.marsexploration.logic.PitsMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;
import com.codecool.marsexploration.logic.Maps.CollectMapElements;
import com.codecool.marsexploration.logic.strategies.SizeStrategies;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PitsMapGenerator implements CreateMap {

    public List<MapElement> createPitsMap(String size) {
        char[][] small = new char[5][5];
        char[][] medium = new char[15][15];
        SizeStrategies sizeStrategies = new SizeStrategies();
        int counter = sizeStrategies.createCounter(size);
        switch (size) {
            case "SMALL":
                return createARandomMap(small, Terrains.PITS, Resources.WATER, counter);
            case "MEDIUM":
                return createARandomMap(medium, Terrains.PITS, Resources.WATER, counter);
            default:
                System.out.println("Size does not exist");
        }
        List<MapElement> allTheMapElements = new ArrayList<>();
        MapElement map = new MapElement(new char[0][0]);
        allTheMapElements.add(map);
        return allTheMapElements;
    }

    @Override
    public List<MapElement> createARandomMap(char[][] size, Terrains terrains, Resources resources, int counter) {
        GenerateRandomMap generateRandomMap = new GenerateRandomMap(size, terrains, resources);
        CollectMapElements collectMapElements = new CollectMapElements();
        generateRandomMap.initialize();
        while (counter != 0){
            char[][] map = generateRandomMap.generateMap();

            while (checkIfMapIsEmpty(map)) {
                map = generateRandomMap.generateMap();
            }

            collectMapElements.saveAllMapElements(map);
        }
        return collectMapElements.getAllElements();
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
