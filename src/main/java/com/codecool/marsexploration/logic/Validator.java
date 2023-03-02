package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Pit;

import java.util.List;

public class Validator {
    private char[][] terrain;
    private List<MapElement> mapElementElements;
    private List<Pit> pitElements;

    public Validator(char[][] terrain, List<MapElement> mapElementElements, List<Pit> pitElements) {
        this.terrain = terrain;
        this.mapElementElements = mapElementElements;
        this.pitElements = pitElements;
    }

    private static int[][] bin = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };


    public static void checkIfElementFits() {
        // a list of elements will arrive as parameter
        System.out.println(isEnoughSpace(1, 1));// output - true
        System.out.println(isEnoughSpace(2, 2));// output - true
        System.out.println(isEnoughSpace(3, 3));// output - true
        System.out.println(isEnoughSpace(1, 3));// output - true
        System.out.println(isEnoughSpace(3, 1));// output - true
        System.out.println(isEnoughSpace(4, 1));// output - false
        System.out.println(isEnoughSpace(4, 5));// output - false
        System.out.println(isEnoughSpace(11, 11));// output - false
        System.out.println(isEnoughSpace(0, 0));// output - true
    }

    private static boolean isEnoughSpace(int rectHeight, int recWidth) {
        for (int row = 0; row <= (bin.length - rectHeight); row++) {
            for (int col = 0; col <= (bin[0].length - recWidth); col++) {
                if (isEnoughSpace(row, col, rectHeight, recWidth)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isEnoughSpace(int rowIndex, int colIndex, int rectHeight, int recWidth) {
        for (int row = rowIndex; row < (rowIndex + rectHeight); row++) {
            for (int col = colIndex; col < (colIndex + recWidth); col++) {
                if (bin[row][col] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

