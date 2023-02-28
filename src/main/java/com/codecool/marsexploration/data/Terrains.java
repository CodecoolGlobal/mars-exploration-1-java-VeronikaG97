package com.codecool.marsexploration.data;

public enum Terrains {
    MOUNTAIN("^"),
    PITS("#");

    String terrain;
    Terrains(String terrain) {
        this.terrain=terrain;
    }

    public String getTerrain() {
        return terrain;
    }
}
