//package com.twu.biblioteca;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//import java.time.Year;
//import java.util.ArrayList;
//import java.util.Collections;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//class BookViewerTest {
//    @Test
//    void shouldDisplayTheDetailsOfMultipleBooks() {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(byteArrayOutputStream));
//        BookList bookInventory = mock(BookList.class);
//        when(bookInventory.getBooks()).thenReturn(new ArrayList<>(Collections.singletonList(new Book("Famous Five", "Enid Mary Blyton", Year.of(1942)))));
//        String expected = "Title: Famous Five Author: Enid Mary Blyton Year Of Publish: 1942\n";
//        BookViewer bookViewer = new BookViewer(bookInventory);
//
//        bookViewer.printBookDetails();
//
//        assertEquals(expected, byteArrayOutputStream.toString());
//    }
//}