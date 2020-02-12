package com.twu.biblioteca;

import java.io.IOException;

public class Validation {

    private UserInput userInput;

    public Validation(UserInput userInput) {
        this.userInput = userInput;
    }

    public boolean isValid() throws IOException {
        String libraryNumber = userInput.scanLibraryNumber();
        String password = userInput.scanUserPassword();
        return false;
    }
}
