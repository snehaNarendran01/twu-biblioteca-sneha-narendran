package com.twu.biblioteca;

import java.io.IOException;

public class CheckoutBook implements Command {
    private BookList bookList;
    private Validator validator;

    CheckoutBook(BookList bookList, Validator validator) {
        this.bookList = bookList;
        this.validator = validator;
    }

    @Override
    public int getOption() {
        return 2;
    }

    @Override
    public void execute() throws IOException {
        if (validator.isValid()) {
            bookList.checkout();
        }
    }
}
