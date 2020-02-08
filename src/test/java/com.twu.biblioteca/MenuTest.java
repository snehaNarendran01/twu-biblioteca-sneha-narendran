package com.twu.biblioteca;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void shouldShowInvalidOptionMessageIfChosenOptionIsIncorrect() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer);
        String expectedErrorMessage = "Please select a valid option!";

        menu.showMenu(8);
        menu.displayInvalidOptionMessage();

        assertEquals(expectedErrorMessage, byteArrayOutputStream.toString());
    }

    @Test
    void shouldNotShowInvalidOptionMessageIfChosenOptionIsCorrect() {
        BookViewer bookViewer = mock(BookViewer.class);
        Menu menu = new Menu(bookViewer);

        menu.showMenu(1);
        menu.displayInvalidOptionMessage();
    }

}