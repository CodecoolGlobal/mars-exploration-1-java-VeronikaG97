package com.codecool.marsexploration;

import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.Maps.MapOfMountains;
import com.codecool.marsexploration.logic.Maps.MapOfPits;

public class Application {

    public static void main(String[] args) {
        /*Instanzen für userInteraction */
        String size = "small"; //later an enum which returns the logic of the userInteraction
        MapOfMountains mapOfMountains = new MapOfMountains();
        MapOfPits mapOfPits = new MapOfPits();
        MapGenerator mapGenerator = new MapGenerator(size, mapOfMountains,mapOfPits);
        mapGenerator.generateMap();
        //String vom userInput "small"
        //GeneratorMap -> Map und Pits
    }
}
