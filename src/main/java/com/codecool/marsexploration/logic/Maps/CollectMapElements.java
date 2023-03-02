package com.codecool.marsexploration.logic.Maps;

import com.codecool.marsexploration.data.MapElement;

import java.util.ArrayList;
import java.util.List;

public class CollectMapElements {
    List<MapElement> allElements = new ArrayList<>();
    public List<MapElement> getMapElements(char[][] map){
        setMapElement(new MapElement(map));
        return allElements;
    }

    public void setMapElement(MapElement mapElement) {
        this.allElements.add(mapElement);
    }
}
