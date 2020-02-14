package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private User user;

    CheckoutBook(BookList bookList, User user) {
        this.bookList = bookList;
        this.user = user;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        bookList.checkout(user);
    }

    @Override
    public int getOptionBeforeLogin() throws InvalidOptionException {
        throw new InvalidOptionException();
    }
}
