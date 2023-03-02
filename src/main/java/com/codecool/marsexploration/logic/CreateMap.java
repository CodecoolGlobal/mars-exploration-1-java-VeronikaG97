package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;

import java.util.List;

public interface CreateMap {
    public List<MapElement> createARandomMap(char[][] size, Terrains terrains, Resources resources, int counter);

}
