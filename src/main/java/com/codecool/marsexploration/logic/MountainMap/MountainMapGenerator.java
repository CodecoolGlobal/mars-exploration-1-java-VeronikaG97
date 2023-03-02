package com.codecool.marsexploration.logic.MountainMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.GenerateRandomMap;

public class MountainMapGenerator implements CreateMap{
    public char[][] createMountainsMap(String size) {
        char[][] small = new char[4][4];
        char[][] medium = new char[20][20];
        char[][] large = new char[30][30];
        switch (size) {
            case "small":
                return createARandomMap(small, Terrains.MOUNTAIN, Resources.MINERALS);
            case "medium":
                return createARandomMap(medium, Terrains.MOUNTAIN, Resources.MINERALS);
            case "large":
                return createARandomMap(large, Terrains.MOUNTAIN, Resources.MINERALS);
            default:
                System.out.println("Size does not exist");
        }
        char[][] map = new char[0][0];
        return map;
    }

    @Override
    public char[][] createARandomMap(char[][] size, Terrains terrains, Resources resources) {
        GenerateRandomMap generateRandomMap = new GenerateRandomMap(size, terrains, resources);

        generateRandomMap.initialize();
        char[][] map = generateRandomMap.generateMap();

        while (checkIfMapIsEmpty(map)) {
            map = generateRandomMap.generateMap();
            break;
        }

        return map;
    }

    private boolean checkIfMapIsEmpty(char[][] map) {
        boolean notNull = true;
        for (char[] array : map) {
            for (char c : array) {
                if (c != ' ') {
                    notNull = false;
                    break;
                }
            }
        }
        return notNull;
    }
}
