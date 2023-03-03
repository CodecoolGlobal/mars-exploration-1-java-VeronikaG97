package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;

import java.util.List;

public interface CreateMap {

    public List<MapElement> createARandomMap(Configuration configuration);

    public List<MapElement> createRandomEmptyMap(int count);
}
