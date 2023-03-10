package com.codecool.marsexploration.logic.generators;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElementGenerator implements CreateMap {
    @Override
    public List<MapElement> createSmallRandomMap(Configuration configuration) {
        List<MapElement> allMapElements = new ArrayList<>();

        SmallMapGenerator smallMapGenerator = new SmallMapGenerator(configuration.smallMapSize(),
                configuration.terrain(),
                configuration.resource());

        char[][] map;
        for (int i = 0; i < configuration.numberOfSmallMaps(); i++) {
            smallMapGenerator.initialize();
            map = smallMapGenerator.generate();
            allMapElements.add(new MapElement(map));
        }

        return allMapElements;
    }


    @Override
    public List<MapElement> createSmallEmptyMap(int size, int numberOfSmallEmptyMap) {
        List<MapElement> emptyMaps = new ArrayList<>();
        while (numberOfSmallEmptyMap > 0) {
            char[][] map = initialize(size);
            emptyMaps.add(new MapElement(map));
            numberOfSmallEmptyMap--;
        }
        return emptyMaps;
    }

    private char[][] initialize(int size) {
        char[][] emptyElement = new char[size][size];
        Arrays.stream(emptyElement).forEach(row -> Arrays.fill(row, ' '));
        return emptyElement;
    }
}
