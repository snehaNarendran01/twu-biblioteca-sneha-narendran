package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;

public class Validator {
    HashMap<String, String> userCredentials;
    private UserInput userInput;

    public Validator(UserInput userInput, UserOutput userOutput) {
        this.userInput = userInput;
        userCredentials = new HashMap<>();
        userCredentials.put("017-1998", "pass1234");
    }

    public boolean isValid() throws IOException {
        String libraryNumber = userInput.scanLibraryNumber();
        String password = userInput.scanUserPassword();
        String actualPassword = userCredentials.get(libraryNumber);
        return password.equals(actualPassword);
    }
}
