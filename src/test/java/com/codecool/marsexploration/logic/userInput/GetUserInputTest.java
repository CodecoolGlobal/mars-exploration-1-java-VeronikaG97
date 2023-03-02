package com.codecool.marsexploration.logic.userInput;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class GetUserInputTest{
    public static Stream<Arguments> provideStringsForGetUserInput() {
        return Stream.of(
                Arguments.of("", false),
                Arguments.of("dasdjdhjkh", false),
                Arguments.of("SMALL", true),
                Arguments.of("MEDIUM", true),
                Arguments.of("LARGE", true),
                Arguments.of("not blank", false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForGetUserInput")
    void getUserInput() {
           assertAll();
    }
}