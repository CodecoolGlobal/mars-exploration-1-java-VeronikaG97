package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.generators.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;
import com.codecool.marsexploration.logic.userInput.InputPrompter;
import com.codecool.marsexploration.logic.userInput.ValidateUserInput;

import static com.codecool.marsexploration.data.Resources.MINERALS;
import static com.codecool.marsexploration.data.Resources.WATER;
import static com.codecool.marsexploration.data.Terrains.MOUNTAIN;
import static com.codecool.marsexploration.data.Terrains.PITS;

public class Application {

    public static void main(String[] args) {
        GetUserInput userInput = new GetUserInput();
        String strUserInput = userInput.getUserInput();
        ValidateUserInput validateUserInput = new ValidateUserInput();

        InputPrompter inputPrompter = new InputPrompter();
        inputPrompter.prompt(strUserInput, validateUserInput, userInput);

        final int FAT_MAP_SIZE = MapSize.valueOf(strUserInput).getSize();
        final int RESOURCE_LIMIT = MapSize.valueOf(strUserInput).getResourceLimit();
//        final int TERRAIN_LIMIT = Math.round(FAT_MAP_SIZE / 2 - 2);
        final int TERRAIN_LIMIT = 5;

        Configuration configurationMountain = new Configuration(FAT_MAP_SIZE, RESOURCE_LIMIT, TERRAIN_LIMIT, MOUNTAIN, MINERALS);
        Configuration configurationPits = new Configuration(FAT_MAP_SIZE, RESOURCE_LIMIT, TERRAIN_LIMIT, PITS, WATER);

        BigEmptyMapGenerator bigEmptyMapGenerator = new BigEmptyMapGenerator(FAT_MAP_SIZE);
        bigEmptyMapGenerator.generateBigMap();

        MapGenerator mapGenerator = new MapGenerator(configurationMountain, configurationPits, bigEmptyMapGenerator);
        mapGenerator.generateEmptyBigFatMap();
        mapGenerator.generateMap();
    }
}
