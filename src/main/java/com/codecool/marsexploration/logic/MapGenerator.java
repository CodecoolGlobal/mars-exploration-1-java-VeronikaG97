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
        //MountainMap generieren von der gewünschten Größe und i erwarte mir {{^,*,^,}}
        //PitsMap generieren von der gewünschten Größe und i erwarte mir {{#,#,~,#}}
        mountainMapGenerator.createMountainsMap(size);
        pitsMapGenerator.createPitsMap(size);
        //Validate
        //Map(Record)
        //Write a file of complete Map
    }
}
