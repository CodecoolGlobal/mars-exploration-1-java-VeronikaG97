package com.codecool.marsexploration.logic.bigMap;

public class BigEmptyMapGenerator {
    private String userInput;
    private char[][] bigMap;

    public BigEmptyMapGenerator(String userInput) {
        this.userInput = userInput;
        translateUserInputToSize();
    }

    private void translateUserInputToSize() {
        switch (getUserInput()) {
            case "SMALL" -> generateBigMap(20);
            case "MEDIUM" -> generateBigMap(40);
            case "LARGE"-> generateBigMap(60);
            default -> generateBigMap(0);
        }
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

    public String getUserInput() {
        return userInput;
    }
    public char[][] getBigMap() {
        return bigMap;
    }
}
