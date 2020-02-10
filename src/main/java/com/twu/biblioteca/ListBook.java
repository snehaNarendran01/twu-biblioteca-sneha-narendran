package com.twu.biblioteca;

public class ListBook implements Command {
    private BookViewer bookViewer;

    ListBook(BookViewer bookViewer) {
        this.bookViewer = bookViewer;
    }

    @Override
    public int getOption() {
        return 1;
    }

    @Override
    public void execute() {
        bookViewer.printBookDetails();
    }
}
