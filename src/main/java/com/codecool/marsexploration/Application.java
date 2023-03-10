package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.io.FileWriter;
import com.codecool.marsexploration.io.Printer;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.assembler.BigMapAssembler;
import com.codecool.marsexploration.logic.generators.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.generators.ElementGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;
import com.codecool.marsexploration.logic.userInput.InputPrompter;
import com.codecool.marsexploration.logic.userInput.ValidateUserInput;

import java.util.List;

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

        final int FAT_MAP_SIZE = MapSize.valueOf(strUserInput).getBigMapSize();
        final int SMALL_MAP_SIZE = MapSize.valueOf(strUserInput).getSmallMapSize();
        final int NUMBER_OF_SMALL_MAPS = MapSize.valueOf(strUserInput).getNumberOfSmallMaps();

        Configuration configurationMountain = new Configuration(FAT_MAP_SIZE, SMALL_MAP_SIZE, NUMBER_OF_SMALL_MAPS, MOUNTAIN, MINERALS);
        Configuration configurationPits = new Configuration(FAT_MAP_SIZE, SMALL_MAP_SIZE, NUMBER_OF_SMALL_MAPS, PITS, WATER);

        BigEmptyMapGenerator bigEmptyMapGenerator = new BigEmptyMapGenerator(FAT_MAP_SIZE);
        bigEmptyMapGenerator.generateBigMap();

        MapGenerator mapGenerator = new MapGenerator(configurationMountain,
                configurationPits,
                bigEmptyMapGenerator,
                new ElementGenerator());

        List<MapElement> allMapElements = mapGenerator.generateMap();
        BigMapAssembler bigMapAssembler = new BigMapAssembler(bigEmptyMapGenerator.getBigMap(), allMapElements);
        bigMapAssembler.assemble();

        char[][] finalReadyBigMap = bigMapAssembler.getBigMap();

        Printer.printMap(finalReadyBigMap);

        FileWriter fileWriter = new FileWriter();
        fileWriter.write(finalReadyBigMap);
    }
}
