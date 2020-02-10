package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;

public class Menu {
    private UserInput userInput;
    private BookViewer bookViewer;
    private BookList bookList;

    public Menu(BookViewer bookViewer, BookList bookInventory, UserInput userInput) {
        this.bookViewer = bookViewer;
        this.bookList = bookInventory;
        this.userInput = userInput;
    }

    public void showMenu() throws IOException {
        int option = userInput.scanOption();
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
    }

    public void displayMenu() {
        System.out.print("\nSelect any one of the options: \n1: Listing all books\n" +
                "2: Checkout a specified book\n3: Return a book\n4: Quit the application\n");
    }

    private void displayInvalidOptionMessage() {
        System.out.print("Please select a valid option!");
    }

    private ArrayList<Command> getCommands() {
        ArrayList<Command> commandList = new ArrayList<>();
        commandList.add(new ListBook(bookViewer));
        commandList.add(new CheckoutBook(bookList, userInput));
        commandList.add(new ReturnBook(bookList));
        commandList.add(new SystemExit());
        return commandList;
    }

}
