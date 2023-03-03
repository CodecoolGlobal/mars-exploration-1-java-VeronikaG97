package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.MountainMap.ElementGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;

public class Application {

    public static void main(String[] args) {
        GetUserInput userInput = new GetUserInput();
        String size = userInput.getUserInput();
        ElementGenerator elementGenerator = new ElementGenerator();
        MapGenerator mapGenerator = new MapGenerator(size, elementGenerator);
        mapGenerator.generateMap();
    }
}
