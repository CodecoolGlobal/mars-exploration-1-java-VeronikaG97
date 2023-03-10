package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.logic.assembler.BigMapAssembler;
import com.codecool.marsexploration.logic.generators.BigEmptyMapGenerator;
import com.codecool.marsexploration.logic.generators.CreateMap;

import java.util.ArrayList;
import java.util.List;

public class MapGenerator {
    private final Configuration configurationMountain;
    private final Configuration configurationPits;
    private final BigEmptyMapGenerator bigEmptyMapGenerator;
    private final CreateMap generator;

    public MapGenerator(Configuration configurationMountain,
                        Configuration configurationPits,
                        BigEmptyMapGenerator bigEmptyMapGenerator,
                        CreateMap generator) {
        this.configurationMountain = configurationMountain;
        this.configurationPits = configurationPits;
        this.bigEmptyMapGenerator = bigEmptyMapGenerator;
        this.generator = generator;
    }

    public List<MapElement> generateMap() {
        List<MapElement> mountainElements = generator.createSmallRandomMap(configurationMountain);
        List<MapElement> pitsElements = generator.createSmallRandomMap(configurationPits);
        List<MapElement> emptyElements = generator.createSmallEmptyMap(configurationPits.smallMapSize(), configurationPits.numberOfSmallMaps());

        List<MapElement> allMapElements = new ArrayList<>();
        allMapElements.addAll(mountainElements);
        allMapElements.addAll(emptyElements);
        allMapElements.addAll(pitsElements);

        return allMapElements;
    }
}
