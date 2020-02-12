package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;

public class Validation {
    HashMap<String, String> userCredentials;
    private UserInput userInput;

    public Validation(UserInput userInput) {
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
