package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.io.FileWriter;
import com.codecool.marsexploration.logic.generators.CreateMap;
import com.codecool.marsexploration.logic.generators.ElementGenerator;
import com.codecool.marsexploration.logic.generators.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.assembler.BigMapAssembler;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private char[][] bigFatMap;
    private final Configuration configurationMountain;
    private final Configuration configurationPits;
    private final BigEmptyMapGenerator bigEmptyMapGenerator;


    public MapGenerator(Configuration configurationMountain, Configuration configurationPits, BigEmptyMapGenerator bigEmptyMapGenerator) {
        this.configurationMountain = configurationMountain;
        this.configurationPits = configurationPits;
        this.bigEmptyMapGenerator = bigEmptyMapGenerator;
    }

    public void generateMap() {
        List<MapElement> allMapElements = new ArrayList<>();
        BigMapAssembler bigMapAssembler = new BigMapAssembler(bigFatMap, allMapElements);
        CreateMap generator = new ElementGenerator();

        List<MapElement> mountainElements = generator.createRandomSmallMap(configurationMountain);
        List<MapElement> pitsElements = generator.createRandomSmallMap(configurationPits);
        List<MapElement> emptyElements = generator.createRandomSmallEmptyMap(mountainElements.size());

        allMapElements.addAll(mountainElements);
        allMapElements.addAll(emptyElements);
        allMapElements.addAll(pitsElements);

        bigMapAssembler.assemble();
        System.out.println("Is there enough space for all elements: " + bigMapAssembler.checkEnoughSpace());

        char[][] finalReadyBigMap = bigMapAssembler.getBigMap();
        printMap(finalReadyBigMap);
    }

    private static void printMap(char[][] finalReadyBigMap) {
        FileWriter fileWriter = new FileWriter();
        fileWriter.write(finalReadyBigMap);
        for (int i = 0; i < finalReadyBigMap.length; i++) {
            for (int j = 0; j < finalReadyBigMap[0].length; j++) {
                System.out.print(finalReadyBigMap[i][j]);
            }
            System.out.println();
        }
    }

    public void generateEmptyBigFatMap() {
        this.bigFatMap = bigEmptyMapGenerator.getBigMap();
    }
}
