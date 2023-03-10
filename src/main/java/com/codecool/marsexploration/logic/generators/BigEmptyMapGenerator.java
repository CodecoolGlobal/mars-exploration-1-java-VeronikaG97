package com.codecool.marsexploration.logic.generators;

import java.util.Arrays;

public class BigEmptyMapGenerator {
    private char[][] bigMap;
    private final int size;
    public BigEmptyMapGenerator(int size) {
        this.size = size;
    }

    public void generateBigMap() {
        char[][] bigEmptyMap = new char[size][size];
        Arrays.stream(bigEmptyMap).forEach(row -> Arrays.fill(row, '0'));
        this.bigMap = bigEmptyMap;
    }

    public char[][] getBigMap() {
        return bigMap;
    }
}
