package com.codecool.marsexploration.logic.strategies;

public class SizeStrategies {
    public int createCounter(String userInput){
        int counter;
        switch (userInput){
            case "SMALL":
                counter = 4;
                break;
            case "MEDIUM":
                counter = 6;
                break;
            case "LARGE":
                counter = 8;
                break;
            default: counter = 0;
        }
        return counter;
    }
}
