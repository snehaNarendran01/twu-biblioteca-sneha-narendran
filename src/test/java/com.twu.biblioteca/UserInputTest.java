package com.twu.biblioteca;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class UserInputTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void reset() {
        System.setOut(System.out);
    }

    @Test
    void shouldScanTheLibraryNumberOfTheUser() throws IOException {
        String input = "123-4567";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        String actualInput = userInput.scanLibraryNumber();

        Assertions.assertEquals(input, actualInput);
    }

    @Test
    void shouldScanThePasswordOfUser() throws IOException {
        String input = "pass1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        UserInput userInput = new UserInput();

        String actualInput = userInput.scanUserPassword();

        Assertions.assertEquals(input, actualInput);

    }
}