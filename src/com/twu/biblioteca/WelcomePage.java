package com.twu.biblioteca;

class WelcomePage {
    private String welcomeMessage;

    WelcomePage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    String getWelcomeMessage() {
        welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
        return welcomeMessage;
    }
}
