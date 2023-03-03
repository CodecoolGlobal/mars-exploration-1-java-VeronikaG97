package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.io.FileWriter;
import com.codecool.marsexploration.logic.ElementGenerator.ElementGenerator;
import com.codecool.marsexploration.logic.bigMap.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.bigMap.BigMapAssembler;

import java.util.ArrayList;
import java.util.List;

import static com.codecool.marsexploration.data.Resources.MINERALS;
import static com.codecool.marsexploration.data.Resources.WATER;
import static com.codecool.marsexploration.data.Terrains.MOUNTAIN;
import static com.codecool.marsexploration.data.Terrains.PITS;

public class MapGenerator {
    private final int size;
    private final int cntRessourceCharacter;
    private final ElementGenerator elementGenerator;
    private String userInput;


    public MapGenerator(int size, int cntRessourceCharacter, ElementGenerator elementGenerator) {
        this.size = size;
        this.elementGenerator = elementGenerator;
        this.cntRessourceCharacter = cntRessourceCharacter;
    }

    public void generateMap() {
        List<MapElement> mountainElements = elementGenerator.createMountainsMap(size, cntRessourceCharacter, MOUNTAIN, MINERALS);
        List<MapElement> pitElements = elementGenerator.createMountainsMap(size, cntRessourceCharacter, PITS, WATER);
        //TODO: remove magic number
        List<MapElement> emptyElements = elementGenerator.createARandomMap(mountainElements.size() * 20);

        List<MapElement> allMapElements = new ArrayList<>();
        allMapElements.addAll(mountainElements);
        allMapElements.addAll(emptyElements);
        allMapElements.addAll(pitElements);
        //TODO: Create Record for size of characters, counter, size of big map instead
        // of enum MapSize
        BigEmptyMapGenerator bigEmptyMapGenerator = new BigEmptyMapGenerator(size*2);
        char[][] bigMap = bigEmptyMapGenerator.getBigMap();


        BigMapAssembler bigMapAssembler = new BigMapAssembler(bigMap, allMapElements);

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
}
