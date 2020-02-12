package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBook implements Command {
    private BookList bookList;
    UserOutput userOutput = new UserOutput();

    ReturnBook(BookList bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getOption() {
        return 3;
    }

    @Override
    public void execute() throws IOException {
        userOutput.print("Enter a book title to return");
        bookList.returnBook();
    }
}
