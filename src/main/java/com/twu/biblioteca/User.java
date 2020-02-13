package com.twu.biblioteca;

import java.io.IOException;

public class User {
    private static Console console;
    private final String name;
    private final String emailId;
    private final String phoneNumber;

    public User(String name, String emailId, String phoneNumber, Console console) {
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        User.console = console;
    }

    public static User createUser() {
        return new User("Jim", "jim12@gmail.com", "9391049708", console);
    }

    public void printInformation() throws IOException {
        console.print("Name: " + name + "\nEmail-id: " + emailId + "\nContact Number: " + phoneNumber + "\n");
    }
}
