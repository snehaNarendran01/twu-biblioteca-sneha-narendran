package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validator {
    private HashMap<User, ArrayList<String>> userCredentials;
    private Console console;
    private User user;

    public Validator(User user, Console console) {
        this.console = console;
        this.user = user;
        userCredentials = new HashMap<>();
        userCredentials.put(user, new ArrayList<>(List.of("017-1998", "pass1234")));
    }

    public boolean isValid() throws IOException {
        console.print("Enter library number: ");
        String libraryNumber = console.scanLibraryNumber();
        console.print("Enter password: ");
        String password = console.scanUserPassword();
        String userPassword = userCredentials.get(user).get(1);
        String userLibraryNumber = userCredentials.get(user).get(0);
        return password.equals(userPassword) && libraryNumber.equals(userLibraryNumber);
    }
}
