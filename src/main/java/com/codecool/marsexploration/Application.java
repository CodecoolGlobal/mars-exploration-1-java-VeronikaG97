package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Configuration;
import com.codecool.marsexploration.data.MapSize;
import com.codecool.marsexploration.data.Resources;
import com.codecool.marsexploration.data.Terrains;
import com.codecool.marsexploration.logic.ElementGenerator.ElementGenerator;
import com.codecool.marsexploration.logic.MapGenerator;
import com.codecool.marsexploration.logic.userInput.GetUserInput;
import com.codecool.marsexploration.logic.userInput.InputPrompter;
import com.codecool.marsexploration.logic.userInput.ValidateUserInput;

public class Application {

    public static void main(String[] args) {
        GetUserInput userInput = new GetUserInput();
        String strUserInput = userInput.getUserInput();
        ValidateUserInput validateUserInput = new ValidateUserInput();

        InputPrompter inputPrompter = new InputPrompter();
        inputPrompter.prompt(strUserInput,validateUserInput, userInput);
        int iSize = MapSize.valueOf(strUserInput).getSize();
        int cntRessourceCharacter = MapSize.valueOf(strUserInput).getCntRessourceCharacter();
        Configuration configurationMountain = new Configuration(iSize,cntRessourceCharacter, Terrains.MOUNTAIN, Resources.MINERALS);
        Configuration configurationPits = new Configuration(iSize,cntRessourceCharacter, Terrains.PITS, Resources.WATER);

        ElementGenerator elementGenerator = new ElementGenerator();
        MapGenerator mapGenerator = new MapGenerator(elementGenerator,configurationMountain,configurationPits);
        mapGenerator.generateMap();
    }
}
