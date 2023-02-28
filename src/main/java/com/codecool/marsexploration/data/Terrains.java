package com.codecool.marsexploration.data;

public enum Terrains {
    MOUNTAIN('^'),
    PITS('#');

    char terrain;
    Terrains(char terrain) {
        this.terrain=terrain;
    }

    public char getTerrain() {
        return terrain;
    }
}
