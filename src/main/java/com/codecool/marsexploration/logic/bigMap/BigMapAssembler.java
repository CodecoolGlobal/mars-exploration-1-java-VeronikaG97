package com.codecool.marsexploration.logic.bigMap;

import com.codecool.marsexploration.data.MapElement;

import java.util.*;

public class BigMapAssembler {
    private char[][] bigMap;
    private List<MapElement> mapElements;
    private Queue<Character> elementQueue;

    public BigMapAssembler(char[][] bigMap, List<MapElement> mapElements) {
        this.bigMap = bigMap;
        this.mapElements = mapElements;
        this.elementQueue = new LinkedList<>();
        assemble();
    }

    public boolean assemble() {
        Collections.shuffle(mapElements);

        boolean doAllElementFit = true;

        for (MapElement e : mapElements) {
            putElementCharsToQueue(e);
        }

        for (MapElement e : mapElements) {
            int elementHeight = e.mapElement().length;
            boolean doesElementFit = isEnoughSpace(elementHeight, elementHeight);
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
                if (bigMap[row][col] != '\u0020') {
                    return false;
                }
                bigMap[row][col] = getNextChar();
            }
        }
        return true;
    }

    private void putElementCharsToQueue(MapElement mapElement) {
        for (int i = 0; i < mapElement.mapElement().length; i++) {
            for (int j = 0; j < mapElement.mapElement()[i].length; j++) {
                elementQueue.offer(mapElement.mapElement()[i][j]);
            }
        }
    }

    private char getNextChar() {
        if (elementQueue.peek() == null) return '\u0020';
        return elementQueue.poll();
    }

    public char[][] getBigMap() {
        return bigMap;
    }
}

