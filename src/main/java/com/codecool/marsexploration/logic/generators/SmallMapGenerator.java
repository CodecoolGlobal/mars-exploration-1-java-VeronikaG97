package com.codecool.marsexploration.logic.generators;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;

import java.util.Arrays;
import java.util.Random;


public class SmallMapGenerator {
    private final char[][] definedMap;
    private final Terrains terrain;
    private final Resources resource;
    private final Random random;

    private final int TERRAIN_MIN;
    private final int TERRAIN_MAX;
    private final int RESOURCE_MIN;
    private final int RESOURCE_MAX;
    private final int ARR_LENG_MIN;
    private final int ARR_LENG_MAX;

    public SmallMapGenerator(int size, Terrains terrain, Resources resource) {
        this.definedMap = new char[size][size];
        this.terrain = terrain;
        this.resource = resource;
        random = new Random();
        TERRAIN_MIN = 4;
        TERRAIN_MAX = 5;
        RESOURCE_MIN = 1;
        RESOURCE_MAX = 2;
        ARR_LENG_MIN = 0;
        ARR_LENG_MAX = size - 1;
    }
    public void initialize() {
        Arrays.stream(definedMap).forEach(row -> Arrays.fill(row, ' '));
    }

    public char[][] generate() {
        final int randomTerrainLimit = getRandomTerrainLimit(TERRAIN_MIN, TERRAIN_MAX);
        final int randomResourceLimit = getRandomTerrainLimit(RESOURCE_MIN, RESOURCE_MAX);
        populateSmallMapWithElements(terrain.getTerrain(), randomTerrainLimit);
        populateSmallMapWithElements(resource.getResource(), randomResourceLimit);
        return getClone();
    }

    private int getRandomTerrainLimit(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    private char[][] getClone() {
        return Arrays.stream(definedMap).map(char[]::clone).toArray(char[][]::new);
    }

    private void populateSmallMapWithElements(char symbol, int elementLimit) {
        int[] freePlaceIndices;
        int i,j;
        for (int count = 0; count < elementLimit; count++) {
            freePlaceIndices = getRandomFreePlaceIndices(ARR_LENG_MIN, ARR_LENG_MAX);
            i = freePlaceIndices[0];
            j = freePlaceIndices[1];
            definedMap[i][j] = symbol;
        }
    }

    private int[] getRandomFreePlaceIndices(int min, int max) {
        int i, j;
        do {
            i = random.nextInt(max - min + 1) + min;
            j = random.nextInt(max - min + 1) + min;
        } while (definedMap[i][j] != ' ');
        return new int[]{i, j};
    }

}