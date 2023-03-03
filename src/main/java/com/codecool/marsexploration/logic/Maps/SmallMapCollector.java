package com.codecool.marsexploration.logic.Maps;

import com.codecool.marsexploration.data.MapElement;

import java.util.ArrayList;
import java.util.List;

public class SmallMapCollector {
    List<MapElement> allElements = new ArrayList<>();
    public void saveAllMapElements(char[][] map){
        setMapElement(new MapElement(map));
    }

    public void setMapElement(MapElement mapElement) {
        this.allElements.add(mapElement);
    }
    public List<MapElement> getAllElements() {
        return allElements;
    }
}
