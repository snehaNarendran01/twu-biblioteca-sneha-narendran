package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class ConsoleTest {
    @Test
    void shouldDisplayTheOutput() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String message = "This is to be printed";
        Console console = new Console();

        console.print(message);

        Assertions.assertEquals(message, byteArrayOutputStream.toString());
    }

    @Test
    void shouldScanTheLibraryNumberOfTheUser() throws IOException {
        String input = "123-4567";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console console = new Console();

        String actualInput = console.scanLibraryNumber();

        Assertions.assertEquals(input, actualInput);
    }

    @Test
    void shouldScanBookTitle() throws IOException {
        String input = "Harry Potter";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console console = new Console();

        String actualInput = console.scanBookTitle();

        Assertions.assertEquals(input, actualInput);
    }

    @Test
    void shouldScanMovieTitle() throws IOException {
        String input = "Birds Of Prey";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console console = new Console();

        String actualInput = console.scanMovieTitle();

        Assertions.assertEquals(input, actualInput);
    }

    @Test
    void shouldScanThePasswordOfUser() throws IOException {
        String input = "pass1234";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console console = new Console();

        String actualInput = console.scanUserPassword();

        Assertions.assertEquals(input, actualInput);
    }
}