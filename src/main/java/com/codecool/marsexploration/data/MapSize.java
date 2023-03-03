package com.codecool.marsexploration.data;

public enum MapSize {
    SMALL(10, 4),
    MEDIUM(15, 6),
    LARGE(20, 8),
    ;
    int size;
    int cntRessourceCharacter;
    MapSize(int size, int cntRessourceCharacter) {
        this.size = size;
        this.cntRessourceCharacter = cntRessourceCharacter;
    }

    public int getSize() {
        return size;
    }

    public int getCntRessourceCharacter() {
        return cntRessourceCharacter;
    }
}
