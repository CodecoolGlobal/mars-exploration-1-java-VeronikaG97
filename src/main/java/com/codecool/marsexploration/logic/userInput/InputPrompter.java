package com.codecool.marsexploration.logic.userInput;

public class InputPrompter {
    public void prompt(String strUserInput,ValidateUserInput validateUserInput,GetUserInput userInput) {
        while(!validateUserInput.validate(strUserInput)) {
            strUserInput = userInput.getUserInput();
        }
    }
}
