package com.codecool.marsexploration.logic.bigMap;

public class BigEmptyMapGenerator {
//    private String userInput;
    private char[][] bigMap;
    private final int size;
    public BigEmptyMapGenerator(int size) {
        this.size = size;
        //TODO: extract from constructor - SOLID principles
        generateBigMap(size);
    }

    public void generateBigMap(int bigMapWidth) {
        char[][] bigEmptyMap = new char[bigMapWidth][bigMapWidth];

        for (int i = 0; i < bigEmptyMap.length; i++) {
            for (int j = 0; j < bigEmptyMap[0].length; j++) {
                bigEmptyMap[i][j] = '\u0020';
            }
        }

        this.bigMap = bigEmptyMap;
    }

//    public String getUserInput() {
//        return userInput;
//    }
    public char[][] getBigMap() {
        return bigMap;
    }
}
