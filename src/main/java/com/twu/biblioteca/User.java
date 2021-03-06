package com.twu.biblioteca;

import java.io.IOException;

public class User {
    private final String name;
    private final String emailId;
    private final String phoneNumber;
    private Console console;

    public User(String name, String emailId, String phoneNumber, Console console) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.console = console;
    }

    public void printInformation() throws IOException {
        console.print("Name: " + name + "\nEmail-id: " + emailId + "\nContact Number: " + phoneNumber + "\n");
    }
}
