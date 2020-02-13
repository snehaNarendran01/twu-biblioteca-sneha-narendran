package com.twu.biblioteca;

import java.io.IOException;

public class WelcomePage {
    private Console console;

    public WelcomePage(Console console) {
        this.console = console;
    }

    public void getWelcomeMessage() throws IOException {
        console.print("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }
}
