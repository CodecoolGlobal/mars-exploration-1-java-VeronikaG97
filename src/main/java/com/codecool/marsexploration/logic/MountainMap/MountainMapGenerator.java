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
import java.util.stream.Collectors;

public class MountainMapGenerator implements CreateMap {
    public List<MapElement> createMountainsMap(String size) {
        char[][] small = new char[4][4];
        char[][] medium = new char[20][20];
        char[][] large = new char[30][30];
        SizeStrategies sizeStrategies = new SizeStrategies();
        int counter = sizeStrategies.createCounter(size);
        switch (size) {
            case "SMALL":
                return createARandomMap(small, Terrains.MOUNTAIN, Resources.MINERALS, counter);
            case "MEDIUM":
                return createARandomMap(medium, Terrains.MOUNTAIN, Resources.MINERALS, counter);
            case "LARGE":
                return createARandomMap(large, Terrains.MOUNTAIN, Resources.MINERALS, counter);
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

        List<MapElement> finalMapOfMountains =  collectMapElements.getAllElements();

        return finalMapOfMountains;
    }

    private char[][] deleteEmptyRows(char[][] map) {
        System.out.println(map.length + "Length of map");
        List<char[]> mapList = Arrays.stream(map).filter(row -> isEmptyRow(row)).collect(Collectors.toList());
        char[][] newMap = mapList.toArray(new char[][]{});
        return newMap;

    }

    private boolean isEmptyRow(char[] row) {
        for (char c : row) {
            char targetCharacter = ' ';
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
                if (c != ' ') {
                    notNull = false;
                    break;
                }
            }
        }
        return notNull;
    }
}
