package com.codecool.marsexploration.io;

import java.util.Arrays;

public class Printer {
    public static void printMap(char[][] map) {
        Arrays.stream(map).forEach(System.out::println);
    }
}
