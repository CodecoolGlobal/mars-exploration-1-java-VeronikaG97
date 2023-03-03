package com.codecool.marsexploration;

import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.logic.ElementGenerator.ElementGenerator;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;
import com.codecool.marsexploration.logic.userInput.ValidateUserInput;

public class Application {

    public static void main(String[] args) {
        GetUserInput userInput = new GetUserInput();
        String strUserInput = userInput.getUserInput();
        ValidateUserInput validateUserInput = new ValidateUserInput();
        //TODO: loop in own function
        while(!validateUserInput.validate(strUserInput)) {
            strUserInput = userInput.getUserInput();
        }
        int iSize = MapSize.valueOf(strUserInput).getSize();
        int cntRessourceCharacter = MapSize.valueOf(strUserInput).getCntRessourceCharacter();
        ElementGenerator elementGenerator = new ElementGenerator();
        MapGenerator mapGenerator = new MapGenerator(iSize, cntRessourceCharacter, elementGenerator);
        mapGenerator.generateMap();
    }
}
