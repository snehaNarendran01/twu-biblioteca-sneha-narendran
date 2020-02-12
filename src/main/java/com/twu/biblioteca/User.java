package com.twu.biblioteca;

import java.io.IOException;

public class User {
    private final String name;
    private final String emailId;
    private final String phoneNumber;
    private UserOutput userOutput;
    private final String libraryNumber;
    private final String password;

    public User(String name, String emailId, String phoneNumber, UserOutput userOutput, String libraryNumber, String password) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.userOutput = userOutput;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public void printInformation() throws IOException {
        userOutput.print("Name: " + name + "\nEmail-id: " + emailId + "\nContact Number: " + phoneNumber + "\n");
    }
}
