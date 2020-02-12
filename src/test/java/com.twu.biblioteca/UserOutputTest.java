package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

class UserOutputTest {
    @Test
    void shouldDisplayTheOutput() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        String message="This is to be printed";
        UserOutput userOutput = new UserOutput();

        userOutput.print(message);

        Assertions.assertEquals(message,byteArrayOutputStream.toString());
    }
}