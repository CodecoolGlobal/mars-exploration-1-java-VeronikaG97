package com.codecool.marsexploration.logic.MountainMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;

public class MountainMapGenerator implements CreateMap {


    public char[][] createMountainsMap(String size) {
        char[][] small=new char[2][4];
        char[][]medium=new char[20][20];
        char[][]large = new char[30][30];
        switch (size) {
            case "small":  return createARandomMap(small,Terrains.MOUNTAIN, Resources.MINERALS);
            case "medium": return createARandomMap(medium,Terrains.MOUNTAIN,Resources.MINERALS);
            case"large":return createARandomMap(large,Terrains.MOUNTAIN,Resources.MINERALS);
            default:
                System.out.println("Size does not exist");
        }
        char[][] map = new char[0][0];
        return map;
    }

    @Override
    public char[][] createARandomMap(char[][] size, Terrains terrains, Resources resources) {
        GenerateRandomMap generateRandomMap = new GenerateRandomMap(size, terrains, resources);
        char[][] map = generateRandomMap.generateMap();
        return map;
    }
}
