package com.twu.biblioteca;

import java.io.IOException;
import java.util.HashMap;

public class Validator {
    private HashMap<String, String> userCredentials;
    private Console console;

    public Validator(Console console) {
        this.console = console;
        userCredentials = new HashMap<>();
        userCredentials.put("017-1998", "pass1234");
    }

    public boolean isValid() throws IOException {
        console.print("Enter library number: ");
        String libraryNumber = console.scanLibraryNumber();
        console.print("Enter password: ");
        String password = console.scanUserPassword();
        String actualPassword = userCredentials.get(libraryNumber);
        return password.equals(actualPassword);
    }
}
