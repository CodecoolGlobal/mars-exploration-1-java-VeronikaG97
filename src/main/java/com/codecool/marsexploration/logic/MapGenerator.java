package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.logic.MountainMap.MountainMapGenerator;
import com.codecool.marsexploration.logic.PitsMap.PitsMapGenerator;
import com.codecool.marsexploration.logic.bigMap.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.bigMap.Validator;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private final String size;
    private final PitsMapGenerator pitsMapGenerator;
    private final MountainMapGenerator mountainMapGenerator;
    private String userInput;

    public MapGenerator(String size, MountainMapGenerator mountainMapGenerator, PitsMapGenerator pitsMapGenerator) {
        this.size = size;
        this.mountainMapGenerator = mountainMapGenerator;
        this.pitsMapGenerator = pitsMapGenerator;
//            this.userInput = userInput;

    }

    public void generateMap() {
        List<MapElement> mountainElements = mountainMapGenerator.createMountainsMap(size);
        List<MapElement> pitElements = pitsMapGenerator.createPitsMap(size);

        List<MapElement> allMapElements = new ArrayList<>();
        allMapElements.addAll(mountainElements);
        allMapElements.addAll(pitElements);

        String userInput = "MEDIUM";

        BigEmptyMapGenerator bigEmptyMapGenerator = new BigEmptyMapGenerator(userInput);

        char[][] bigMap = bigEmptyMapGenerator.getBigMap();


        Validator validator = new Validator(bigMap, allMapElements);
        //Validate
        //Generate finished whole Map
        //Write it to file
    }
}
