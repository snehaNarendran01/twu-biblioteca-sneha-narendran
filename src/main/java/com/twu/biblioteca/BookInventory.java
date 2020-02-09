package com.twu.biblioteca;

import java.time.Year;
import java.util.ArrayList;

public class BookInventory {
    private ArrayList<Book> inventory;

    public BookInventory() {
        this.inventory = new ArrayList<>();
        inventory.add(new Book("Famous Five", "Enid Mary Blyton", Year.of(1942)));
        inventory.add(new Book("Harry Potter", "J.K Rowling", Year.of(1997)));
    }

    public void remove(Book book) {
        if (!inventory.contains(book)) {
            System.out.print("Sorry, that book is not available");
            return;
        }
        inventory.remove(book);
        System.out.print("Thank you! Enjoy the book");
    }

    public void add(Book book) {
        if (inventory.contains(book)) {
            return;
        }
        inventory.add(book);
    }

    public void returnBook(Book book) {
        System.out.print("That is not a valid book to return.");

    }
}
