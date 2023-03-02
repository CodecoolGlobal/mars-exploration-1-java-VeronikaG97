package com.codecool.marsexploration.logic.userInput;

import com.codecool.marsexploration.data.MapSize;
public class ValidateUserInput {
    public String validate(String userInput) {
        GetUserInput getUserInput = new GetUserInput();
        if (!(userInput.equals(MapSize.SMALL.name()) || userInput.equals(MapSize.MEDIUM.name()) || userInput.equals(MapSize.LARGE.name()))){
            System.out.println("Please check for typos and try again!");
             getUserInput.getUserInput();
        } else {
            System.out.println("Hey, the input was correct! :D");
            return userInput;
        }
        return null;
    }
}
