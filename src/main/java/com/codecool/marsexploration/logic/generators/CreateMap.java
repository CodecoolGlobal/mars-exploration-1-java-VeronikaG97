package com.codecool.marsexploration.logic.generators;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapElement;

import java.util.List;

public interface CreateMap {
    List<MapElement> createRandomSmallMap(Configuration configuration);
    List<MapElement> createRandomSmallEmptyMap(int count);
}
