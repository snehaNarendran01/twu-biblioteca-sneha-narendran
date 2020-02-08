package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenu() {
        Menu menu = new Menu();
        BookViewer bookViewer = mock(BookViewer.class);

        menu.showMenu(bookViewer);

        verify(bookViewer,times(1)).printBookDetails();
    }
}