package com.codecool.marsexploration.data;

public enum MapSize {
    SMALL(10, 4),
    MEDIUM(15, 6),
    LARGE(20, 8),
    ;
    int size;
    int resourceLimit;
    MapSize(int size, int cntRessourceCharacter) {
        this.size = size;
        this.resourceLimit = cntRessourceCharacter;
    }

    public int getSize() {
        return size;
    }

    public int getResourceLimit() {
        return resourceLimit;
    }
}
