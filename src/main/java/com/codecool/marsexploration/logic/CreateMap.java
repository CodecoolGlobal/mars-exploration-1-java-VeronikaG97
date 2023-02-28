package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;

public interface CreateMap {
    public char[][] createARandomMap(char[][] size, Terrains terrains, Resources resources);
}
