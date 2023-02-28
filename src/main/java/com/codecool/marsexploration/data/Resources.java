package com.codecool.marsexploration.data;

public enum Resources {
    MINERALS("*"),
    WATER("~");

    String resources;
    Resources(String resources) {
        this.resources=resources;
    }

    public String getResources() {
        return resources;
    }
}
