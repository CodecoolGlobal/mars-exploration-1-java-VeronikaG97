package com.codecool.marsexploration.logic.PitsMap;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.CreateMap;
import com.codecool.marsexploration.logic.MountainMap.GenerateRandomMap;

public class PitsMapGenerator implements CreateMap {

    public char[][] createPitsMap(String size) {
        char[][] small=new char[5][5];
        char[][]medium=new char[15][15];
        switch (size) {
            case "small":  return createARandomMap(small,Terrains.PITS, Resources.WATER);
            case "medium": return createARandomMap(medium,Terrains.PITS,Resources.WATER);
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
