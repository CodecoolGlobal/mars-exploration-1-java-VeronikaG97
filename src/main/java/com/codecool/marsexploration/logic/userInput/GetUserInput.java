package com.codecool.marsexploration.logic.userInput;

import java.util.Scanner;

public class GetUserInput {
    public String getUserInput (){
        System.out.println(
                "Please choose your map size:\n" +
                        "small\n" +
                        "medium\n" +
                        "large");
        Scanner scanner = new Scanner(System.in);
        return scanner.next().toUpperCase();
    }

}
