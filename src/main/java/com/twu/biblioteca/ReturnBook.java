package com.twu.biblioteca;

import java.io.IOException;

public class ReturnBook implements Command {
    private BookList bookList;

    ReturnBook(BookList bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getOption() {
        return 3;
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Enter a book title to return");
        bookList.returnBook();
    }
}
