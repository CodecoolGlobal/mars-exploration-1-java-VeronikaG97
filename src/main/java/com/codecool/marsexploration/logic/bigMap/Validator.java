package com.codecool.marsexploration.logic.bigMap;

import com.codecool.marsexploration.data.MapElement;

import java.util.List;

public class Validator {
    private char[][] bigMap;
    private List<MapElement> mapElements;

    public Validator(char[][] bigMap, List<MapElement> mapElements) {
        this.bigMap = bigMap;
        this.mapElements = mapElements;
    }

    public boolean checkIfElementsFits() {
        boolean doAllElementFit = true;
        for (MapElement e : mapElements) {
            boolean doesElementFit = isEnoughSpace(e.mapElement().length, e.mapElement()[0].length);
            if (!doesElementFit) {
                doAllElementFit = false;
                break;
            }
        }
        return doAllElementFit;
    }

    private boolean isEnoughSpace(int rectHeight, int recWidth) {
        for (int row = 0; row <= (bigMap.length - rectHeight); row++) {
            for (int col = 0; col <= (bigMap[0].length - recWidth); col++) {
                if (isEnoughSpace(row, col, rectHeight, recWidth)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEnoughSpace(int rowIndex, int colIndex, int rectHeight, int recWidth) {
        for (int row = rowIndex; row < (rowIndex + rectHeight); row++) {
            for (int col = colIndex; col < (colIndex + recWidth); col++) {
                if (bigMap[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

