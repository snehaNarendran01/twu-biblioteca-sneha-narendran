package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private Validator validator;
    private User user;

    CheckoutBook(BookList bookList, Validator validator, User user) {
        this.bookList = bookList;
        this.validator = validator;
        this.user = user;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        if (validator.isValid()) {
            bookList.checkout(user);
        }
    }
}
