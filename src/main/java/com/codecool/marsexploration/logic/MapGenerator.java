package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.logic.MountainMap.MountainMapGenerator;
import com.codecool.marsexploration.logic.PitsMap.PitsMapGenerator;

public class MapGenerator {
    private final String size;
    private final PitsMapGenerator pitsMapGenerator;
    private final MountainMapGenerator mountainMapGenerator;

    public MapGenerator(String size, MountainMapGenerator mountainMapGenerator,PitsMapGenerator pitsMapGenerator ) {
            this.size = size;
            this.mountainMapGenerator = mountainMapGenerator;
            this.pitsMapGenerator =pitsMapGenerator;
    }

    public void generateMap() {
        mountainMapGenerator.createMountainsMap(size);
        pitsMapGenerator.createPitsMap(size);
        //Validate
        //Generate finished whole Map
        //Write it to file
    }
}
