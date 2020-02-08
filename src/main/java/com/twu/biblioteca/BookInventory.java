package com.twu.biblioteca;

import java.util.ArrayList;

public class BookInventory {
    private ArrayList<Book> inventory;

    public BookInventory(ArrayList<Book> inventory) {
        this.inventory = inventory;
    }

    public void remove(Book book) throws BookNotFoundException {
        if (!inventory.contains(book))
            throw new BookNotFoundException();

    }
}
