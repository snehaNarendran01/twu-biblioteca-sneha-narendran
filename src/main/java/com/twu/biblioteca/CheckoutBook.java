package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private UserInput userInput;
    private UserOutput userOutput;

    CheckoutBook(BookList bookList, UserInput userInput, UserOutput userOutput) {
        this.bookList = bookList;
        this.userInput = userInput;
        this.userOutput = userOutput;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        userOutput.print("Enter a book title to checkout");
        String title = userInput.scanBookTitle();
        bookList.checkout(title);
    }
}
