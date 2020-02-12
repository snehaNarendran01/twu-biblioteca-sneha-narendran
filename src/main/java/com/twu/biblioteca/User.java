package com.twu.biblioteca;

import java.io.IOException;

public class User {
    private static UserOutput userOutput;
    private final String name;
    private final String emailId;
    private final String phoneNumber;

    public User(String name, String emailId, String phoneNumber, UserOutput userOutput) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        User.userOutput = userOutput;
    }

    public static User createUser() {
        return new User("Jim", "jim12@gmail.com", "9391049708", userOutput);
    }

    public void printInformation() throws IOException {
        userOutput.print("Name: " + name + "\nEmail-id: " + emailId + "\nContact Number: " + phoneNumber + "\n");
    }
}
