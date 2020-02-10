package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private UserInput userInput;

    CheckoutBook(BookList bookList, UserInput userInput) {
        this.bookList = bookList;
        this.userInput = userInput;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Enter a book title to checkout");
        String title = userInput.scanBookTitle();
        bookList.checkout(title);
    }
}
