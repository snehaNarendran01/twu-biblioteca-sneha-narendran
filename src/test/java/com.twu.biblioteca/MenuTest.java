package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenu() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer);

        menu.showMenu();

        verify(bookViewer, times(1)).printBookDetails();
    }
}