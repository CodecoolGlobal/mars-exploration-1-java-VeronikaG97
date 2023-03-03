package com.codecool.marsexploration.logic.generators;

public class BigEmptyMapGenerator {
//    private String userInput;
    private char[][] bigMap;
    private final int size;
    public BigEmptyMapGenerator(int size) {
        this.size = size;
    }

    public void generateBigMap() {
        char[][] bigEmptyMap = new char[size][size];
        for (int i = 0; i < bigEmptyMap.length; i++) {
            for (int j = 0; j < bigEmptyMap[0].length; j++) {
                bigEmptyMap[i][j] = '\u0020';
            }
        }
        this.bigMap = bigEmptyMap;
    }

    public char[][] getBigMap() {
        return bigMap;
    }
}
