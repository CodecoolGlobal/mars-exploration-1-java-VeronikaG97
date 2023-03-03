package com.codecool.marsexploration.logic.userInput;

import com.codecool.marsexploration.data.MapSize;
public class ValidateUserInput {
    public boolean validate(String userInput) {
        return userInput.equalsIgnoreCase(MapSize.SMALL.name()) ||
                userInput.equalsIgnoreCase(MapSize.MEDIUM.name()) ||
                userInput.equalsIgnoreCase(MapSize.LARGE.name());
    }
}
