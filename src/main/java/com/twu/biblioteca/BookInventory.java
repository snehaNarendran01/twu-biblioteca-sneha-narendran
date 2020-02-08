package com.twu.biblioteca;

import java.util.ArrayList;

public class BookInventory {
    private ArrayList<Book> inventory;

    public BookInventory(ArrayList<Book> inventory) {
        this.inventory = inventory;
    }

    public void removeBook(Book book) throws BookNotFoundException {
        if (!inventory.contains(book))
            throw new BookNotFoundException();
        inventory.remove(book);
    }

    public void addBook(Book book) throws BookAlreadyExistException {
        if (inventory.contains(book))
            throw new BookAlreadyExistException();
        inventory.add(book);

    }
}
