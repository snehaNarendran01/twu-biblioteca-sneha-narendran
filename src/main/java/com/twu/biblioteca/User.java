package com.twu.biblioteca;

import java.io.IOException;

public class User {
    private final String name;
    private final String emailId;
    private final String phoneNumber;
    private UserOutput userOutput;

    public User(String name, String emailId, String phoneNumber, UserOutput userOutput) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.userOutput = userOutput;
    }

    public void printInformation() throws IOException {
        userOutput.print("Name: " + name + "\nEmail-id: " + emailId + "\nContact Number: " + phoneNumber + "\n");
    }
}
