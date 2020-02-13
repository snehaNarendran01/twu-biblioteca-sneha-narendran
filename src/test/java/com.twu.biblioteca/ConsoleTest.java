package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}