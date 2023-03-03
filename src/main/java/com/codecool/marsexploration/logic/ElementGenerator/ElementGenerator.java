package com.codecool.marsexploration.logic.MountainMap;

import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;
import com.codecool.marsexploration.logic.Maps.CollectMapElements;
import com.codecool.marsexploration.logic.strategies.SizeStrategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ElementGenerator implements CreateMap {
    public List<MapElement> createMountainsMap(String size, Terrains terrain, Resources mineral) {
        char[][] small = new char[5][5];
        char[][] medium = new char[10][10];
        char[][] large = new char[15][15];
        SizeStrategies sizeStrategies = new SizeStrategies();
        int counter = sizeStrategies.createCounter(size);
        switch (size) {
            case "SMALL":
                return createARandomMap(small,terrain, mineral, counter);
            case "MEDIUM":
                return createARandomMap(medium, terrain, mineral, counter);
            case "LARGE":
                return createARandomMap(large, terrain, mineral, counter);
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

        while (counter > 0) {
            char[][] map = generateRandomMap.generateMap();

            while (checkIfMapIsEmpty(map)) {
                map = generateRandomMap.generateMap();
            }
            char[][] finalMapOfMountains = deleteEmptyRows(map);
            collectMapElements.saveAllMapElements(finalMapOfMountains);
            counter--;
        }

        List<MapElement> finalListOfMapElements =  collectMapElements.getAllElements();

        return finalListOfMapElements;
    }

    private char[][] deleteEmptyRows(char[][] map) {
        List<char[]> mapList = Arrays.stream(map).filter(row -> isEmptyRow(row)).collect(Collectors.toList());
        char[][] newMap = mapList.toArray(new char[][]{});
        return newMap;

    }

    private boolean isEmptyRow(char[] row) {
        for (char c : row) {
            char targetCharacter = '\u0020';
            if (c != targetCharacter) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfMapIsEmpty(char[][] map) {
        boolean notNull = true;
        for (char[] array : map) {
            for (char c : array) {
                if (c != '\u0020') {
                    notNull = false;
                    break;
                }
            }
        }
        return notNull;
    }

    public List<MapElement> createARandomMap(int counter) {
        List<MapElement> emptyMaps = new ArrayList<>();
        while (counter > 0) {
            char[][] map = generateRandomEmptyMap();
            emptyMaps.add(new MapElement(map));
            counter--;
        }
        return emptyMaps;
    }

    public char[][] generateRandomEmptyMap() {
        int randomLimit = 6;
        int arraySize = new Random().nextInt(randomLimit);

        char[][] emptyElement = new char[arraySize][arraySize];

        for (int i = 0; i < emptyElement.length; i++) {
            for (int j = 0; j < emptyElement[i].length; j++) {
                emptyElement[i][j] = '\t';
            }
        }
        return emptyElement;
    }
}
