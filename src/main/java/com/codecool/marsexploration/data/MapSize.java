package com.codecool.marsexploration.data;

public enum MapSize {
    SMALL(12, 4, 3),
    MEDIUM(24, 4, 12),
    LARGE(48, 4, 48);

    int bigMapSize;
    int smallMapSize;
    int numberOfSmallMaps;

    MapSize(int bigMapSize, int smallMapSize, int numberOfSmallMaps) {
        this.bigMapSize = bigMapSize;
        this.smallMapSize = smallMapSize;
        this.numberOfSmallMaps = numberOfSmallMaps;
    }
    public int getBigMapSize() {
        return bigMapSize;
    }

    public int getSmallMapSize() {
        return smallMapSize;
    }

    public int getNumberOfSmallMaps() {
        return numberOfSmallMaps;
    }


}
