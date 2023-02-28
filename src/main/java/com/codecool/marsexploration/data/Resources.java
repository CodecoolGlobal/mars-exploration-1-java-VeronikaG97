package com.codecool.marsexploration.data;

public enum Resources {
    MINERALS('*'),
    WATER('~');

    char resources;
    Resources(char resources) {
        this.resources=resources;
    }

    public char getResources() {
        return resources;
    }
}
