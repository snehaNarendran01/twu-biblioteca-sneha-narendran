package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    private Console console;
    private ApplicationQuitter applicationQuitter;
    private MovieViewer movieViewer;
    private MovieList movieList;
    private Validator validator;
    private User user;
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookList, Console console, ApplicationQuitter applicationQuitter,
                MovieViewer movieViewer, MovieList movieList, Validator validator, User user) {
        this.bookViewer = bookViewer;
        this.bookList = bookList;
        this.console = console;
        this.applicationQuitter = applicationQuitter;
        this.movieViewer = movieViewer;
        this.movieList = movieList;
        this.validator = validator;
        this.user = user;
    }

    public void showMenu() throws IOException {
        int option;
        if (validator.isValid()) {
            do {
                displayAfterLoginMenu();
                option = console.scanOption();
                int flag = 0;
                ArrayList<Command> commands = getCommands();
                for (Command command : commands) {
                    if (command.getOption() == option) {
                        command.execute();
                        flag = 1;
                    }
                }
                if (flag == 0)
                    displayInvalidOptionMessage();
            } while (option != 4);
        } else
            console.print("Invalid Credentials");
    }

    public void displayAfterLoginMenu() throws IOException {
        console.print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n5: Listing all movies\n6: Checkout a movie\n7: Show account details\n");
    }

    private void displayInvalidOptionMessage() throws IOException {
        console.print("Please select a valid option!");
    }

    private ArrayList<Command> getCommands() {
        ArrayList<Command> commandList = new ArrayList<>();
        commandList.add(new ListBook(bookViewer));
        commandList.add(new CheckoutBook(bookList, user));
        commandList.add(new ReturnBook(bookList, user));
        commandList.add(new SystemExit(applicationQuitter));
        commandList.add(new ListMovies(movieViewer));
        commandList.add(new CheckoutMovies(movieList));
        commandList.add(new UserDetails(user));
        return commandList;
    }

    public void displayBeforeLoginMenu() throws IOException {
        console.print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Listing all movies\n3: Login\n4: Quit the application\n");
    }

    public void showBeforeLoginMenu() throws IOException, InvalidOptionException {
        displayBeforeLoginMenu();
        int option;
        do {
            option = console.scanOption();
            ArrayList<Command> commandList = getCommandsBeforeLogin();
            for (Command command : commandList) {
                if (command.getOptionBeforeLogin() == option) {
                    command.execute();
                    if (option == 3)
                        showMenu();
                }
            }
        } while (option != 4);
    }

    private ArrayList<Command> getCommandsBeforeLogin() {
        ArrayList<Command> commandList = new ArrayList<>();
        commandList.add(new ListBook(bookViewer));
        commandList.add(new ListMovies(movieViewer));
        commandList.add(new Login(console, validator));
        commandList.add(new SystemExit(applicationQuitter));
        return commandList;
    }
}
