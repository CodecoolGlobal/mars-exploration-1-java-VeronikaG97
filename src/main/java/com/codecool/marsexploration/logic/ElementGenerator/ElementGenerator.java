package com.codecool.marsexploration.logic.ElementGenerator;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;
import com.codecool.marsexploration.logic.Maps.CollectMapElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ElementGenerator implements CreateMap {

   /* public List<MapElement> createElementMap(Configuration configuration) {
        int size = configuration.size();
        Terrains terrain = configuration.terrain();
        Resources resources = configuration.ressource();
        int counter = configuration.counter();
        char[][] mapElements = new char[size][size];
        return createARandomMap(mapElements, terrain, resources, counter);
    }*/

    @Override
    public List<MapElement> createARandomMap(Configuration configuration) {
//char[][] size, Terrains terrains, Resources resources, int counter
        int size = configuration.size();
        Terrains terrain = configuration.terrain();
        Resources resources = configuration.ressource();
        int counter = configuration.counter();
        char[][] mapElements = new char[size][size];
        GenerateRandomMap generateRandomMap = new GenerateRandomMap(mapElements, terrain, resources);
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

    public List<MapElement> createRandomEmptyMap(int counter) {
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
