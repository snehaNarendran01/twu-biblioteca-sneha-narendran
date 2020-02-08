package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class MenuTest {
    @Test
    void shouldBeAbleToViewTheListOfBooksFromTheMenuIfChoosesOptionOne() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer);

        menu.showMenu(1);

        verify(bookViewer, times(1)).printBookDetails();
    }

    @Test
    void shouldNotBeAbleToViewTheListOfBooksFromTheMenuIfChosenOptionIsNotOne() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer);

        menu.showMenu(2);

        verify(bookViewer, times(0)).printBookDetails();
    }
}