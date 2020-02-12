package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {

    private UserInput userInput;
    private UserOutput userOutput;
    private ApplicationQuitter applicationQuitter;
    private MovieViewer movieViewer;
    private MovieList movieList;
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookInventory, UserInput userInput,
                UserOutput userOutput, ApplicationQuitter applicationQuitter, MovieViewer movieViewer, MovieList movieList) {
        this.bookViewer = bookViewer;
        this.bookList = bookInventory;
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.applicationQuitter = applicationQuitter;
        this.movieViewer = movieViewer;
        this.movieList = movieList;
    }

    public void showMenu() throws IOException {
        int option;
        do {
            displayMenu();
            option = userInput.scanOption();
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
    }


    public void displayMenu() throws IOException {
        userOutput.print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n5: Listing all movies\n");
    }

    private void displayInvalidOptionMessage() throws IOException {
        userOutput.print("Please select a valid option!");
    }

    private ArrayList<Command> getCommands() {
        ArrayList<Command> commandList = new ArrayList<>();
        commandList.add(new ListBook(bookViewer));
        commandList.add(new CheckoutBook(bookList, userInput, userOutput));
        commandList.add(new ReturnBook(bookList));
        commandList.add(new SystemExit(applicationQuitter));
        commandList.add(new ListMovies(movieViewer));
        commandList.add(new CheckoutMovies(movieList, userInput, userOutput));
        return commandList;
    }
}
