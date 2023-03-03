package com.codecool.marsexploration.logic.userInput;

import com.codecool.marsexploration.data.MapSize;
public class ValidateUserInput {
    public boolean validate(String userInput) {
        return userInput.equalsIgnoreCase(MapSize.SMALL.name()) ||
                userInput.equalsIgnoreCase(MapSize.MEDIUM.name()) ||
                userInput.equalsIgnoreCase(MapSize.LARGE.name());

//        GetUserInput getUserInput = new GetUserInput();
//        if (!(userInput.equals(MapSize.SMALL.name()) || userInput.equals(MapSize.MEDIUM.name()) || userInput.equals(MapSize.LARGE.name()))){
//            System.out.println("Please check for typos and try again!");
//             getUserInput.getUserInput();
//        } else {
//            System.out.println("Hey, the input was correct! :D");
//            return userInput;
//        }
//        return null;
    }
}
