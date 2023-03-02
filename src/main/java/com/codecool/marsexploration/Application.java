package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.MountainMap.MountainMapGenerator;
import com.codecool.marsexploration.logic.PitsMap.PitsMapGenerator;

public class Application {

    public static void main(String[] args) {
        /*Instanzen für userInteraction */
        String size = "MEDIUM"; //later an enum which returns the logic of the userInteraction
        MountainMapGenerator mountainMapGenerator = new MountainMapGenerator();
        PitsMapGenerator pitsMapGenerator = new PitsMapGenerator();
        MapGenerator mapGenerator = new MapGenerator(size,mountainMapGenerator,pitsMapGenerator);
        mapGenerator.generateMap();
    }
}
