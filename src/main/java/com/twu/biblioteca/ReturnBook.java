package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBook implements Command {
    UserOutput userOutput = new UserOutput();
    private BookList bookList;
    private Validator validator;
    private User user;

    ReturnBook(BookList bookList, Validator validator, User user) {
        this.bookList = bookList;
        this.validator = validator;
        this.user = user;
    }

    @Override
    public int getOption() {
        return 3;
    }

    @Override
    public void execute() throws IOException {
        if (validator.isValid()) {
            userOutput.print("Enter a book title to return");
            bookList.returnBook(user);
        }
    }
}
