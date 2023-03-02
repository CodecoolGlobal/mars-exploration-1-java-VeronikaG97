package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.MountainMap.MountainMapGenerator;
import com.codecool.marsexploration.logic.PitsMap.PitsMapGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;

public class Application {

    public static void main(String[] args) {
        GetUserInput userInput = new GetUserInput();
        String size = userInput.getUserInput();
        MountainMapGenerator mountainMapGenerator = new MountainMapGenerator();
        PitsMapGenerator pitsMapGenerator = new PitsMapGenerator();
        MapGenerator mapGenerator = new MapGenerator(size,mountainMapGenerator,pitsMapGenerator);
        mapGenerator.generateMap();
    }
}
