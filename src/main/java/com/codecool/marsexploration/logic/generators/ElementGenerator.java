package com.codecool.marsexploration.logic.generators;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.GenerateRandomSmallMap;
import com.codecool.marsexploration.logic.Maps.SmallMapCollector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ElementGenerator implements CreateMap {
    @Override
    public List<MapElement> createRandomSmallMap(Configuration configuration) {
        SmallMapCollector smallMapCollector = new SmallMapCollector();
        int bigFatMapSize = configuration.bigFatMapSize();
        Terrains terrain = configuration.terrain();
        Resources resources = configuration.resource();
        int resourceLimit = configuration.resourceLimit();
        char[][] mapElements = new char[bigFatMapSize][bigFatMapSize];
        GenerateRandomSmallMap generateRandomSmallMap = new GenerateRandomSmallMap(mapElements, terrain, resources);
        generateRandomSmallMap.initialize();
        generateSmallMaps(resourceLimit, generateRandomSmallMap, smallMapCollector);
        List<MapElement> finalListOfMapElements =  smallMapCollector.getAllElements();
        return finalListOfMapElements;
    }

    private void generateSmallMaps(int resourceLimit, GenerateRandomSmallMap generateRandomSmallMap, SmallMapCollector smallMapCollector) {
        while (resourceLimit > 0) {
            char[][] map = generateRandomSmallMap.generateMap();
            while (checkIfMapIsEmpty(map)) {
                map = generateRandomSmallMap.generateMap();
            }
            char[][] finalMapOfMountains = deleteEmptyRows(map);
            smallMapCollector.saveAllMapElements(finalMapOfMountains);
            resourceLimit--;
        }
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

    public List<MapElement> createRandomSmallEmptyMap(int counter) {
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
