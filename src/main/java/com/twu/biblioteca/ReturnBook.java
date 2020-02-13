package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBook implements Command {
    UserOutput userOutput = new UserOutput();
    private BookList bookList;
    private User user;

    ReturnBook(BookList bookList, User user) {
        this.bookList = bookList;
        this.user = user;
    }

    @Override
    public int getOption() {
        return 3;
    }

    @Override
    public void execute() throws IOException {
        userOutput.print("Enter a book title to return");
        bookList.returnBook(user);
    }
}
