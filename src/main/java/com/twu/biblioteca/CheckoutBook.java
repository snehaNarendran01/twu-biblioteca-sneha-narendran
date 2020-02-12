package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private UserInput userInput;
    private UserOutput userOutput;
    private Validator validator;

    CheckoutBook(BookList bookList, UserInput userInput, UserOutput userOutput, Validator validator) {
        this.bookList = bookList;
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.validator = validator;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        if (validator.isValid()) {
            userOutput.print("Enter a book title to checkout");
            String title = userInput.scanBookTitle();
            bookList.checkout(title);
        }
    }
}
