package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.io.FileWriter;
import com.codecool.marsexploration.logic.ElementGenerator.ElementGenerator;
import com.codecool.marsexploration.logic.bigMap.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.bigMap.BigMapAssembler;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.codecool.marsexploration.data.Resources.MINERALS;
import static com.codecool.marsexploration.data.Resources.WATER;
import static com.codecool.marsexploration.data.Terrains.MOUNTAIN;
import static com.codecool.marsexploration.data.Terrains.PITS;

public class MapGenerator {
    private final int size;
    private final int cntRessourceCharacter;
    private final ElementGenerator elementGenerator;
    private final Configuration configurationMountain;
    private final Configuration configrationPits;



    public MapGenerator(ElementGenerator elementGenerator, Configuration configurationMountain, Configuration configurationPits) {
        this.size = configurationMountain.size();
        this.elementGenerator = elementGenerator;
        this.cntRessourceCharacter = configurationMountain.counter();
        this.configurationMountain = configurationMountain;
        this.configrationPits=configurationPits;
    }

    public void generateMap() {

       // List<MapElement> mountainElements = elementGenerator.createElementMap(configurationMountain);
        //List<MapElement> pitElements = elementGenerator.createElementMap(configrationPits);
        //TODO: remove magic number
        CreateMap generator = new ElementGenerator();
        List<MapElement>mountainElements = generator.createARandomMap(configurationMountain);
        List<MapElement>pitsElements = generator.createARandomMap(configrationPits);
       //CreateMap mountainElement = new ElementGenerator();
        //List<MapElement> mountainMap = mountainElement.createARanomMap(asdasdf);

        //List<MapElement> m = mountainElement;
        List<MapElement> emptyElements = generator.createRandomEmptyMap(mountainElements.size() + pitsElements.size());

        List<MapElement> allMapElements = new ArrayList<>();
        allMapElements.addAll(mountainElements);
        allMapElements.addAll(emptyElements);
        allMapElements.addAll(pitsElements);
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
