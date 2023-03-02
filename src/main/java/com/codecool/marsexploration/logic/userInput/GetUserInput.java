package com.codecool.marsexploration.logic.userInput;

import java.util.Scanner;

public class GetUserInput {
    private String userInput;
    public String getUserInput (){
        System.out.println(
                "Please choose your map size:\n" +
                        "small\n" +
                        "medium\n" +
                        "large");
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.next().toUpperCase();
        ValidateUserInput validateUserInput = new ValidateUserInput();
        return validateUserInput.validate(userInput);
    }
}
