package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;

public class Validator {
    private HashMap<String, String> userCredentials;
    private UserInput userInput;
    private UserOutput userOutput;

    public Validator(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        userCredentials = new HashMap<>();
        userCredentials.put("017-1998", "pass1234");
    }

    public boolean isValid() throws IOException {
        userOutput.print("Enter library number: ");
        String libraryNumber = userInput.scanLibraryNumber();
        userOutput.print("Enter password: ");
        String password = userInput.scanUserPassword();
        String actualPassword = userCredentials.get(libraryNumber);
        return password.equals(actualPassword);
    }
}
