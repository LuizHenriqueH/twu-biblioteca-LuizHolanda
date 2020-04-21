package com.twu.biblioteca;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book book = new Book();

    @Test
    public void listBookNotNullTest() {
        book.bookList();
        assertNotNull(book.getBookList());
    }

    @Test
    public void rentABookSuccessMessageTest(){
        String expectedReturnMessage = "Thank you! Enjoy the Book.";
        book.bookList();
        assertEquals(expectedReturnMessage, book.rentABook(2));
    }

    @Test
    public void rentABookUnavailableMessageTest(){
        String expectedReturnMessage = "Sorry! The book is not available.";
        book.bookList();
        book.rentABook(3);
        assertEquals(expectedReturnMessage, book.rentABook(3));
    }

    @Test
    public void returnABookSuccessMessageTest(){
        String expectedReturnMessage = "Thank you for returning the book.";
        book.bookList();
        book.rentABook(4);
        assertEquals(expectedReturnMessage, book.returnABook(4));
    }

    @Test
    public void invalidBookReturnMessageTest(){
        String expectedReturnMessage = "That is not a valid book to return.";
        book.bookList();
        assertEquals(expectedReturnMessage, book.returnABook(4));
    }

    @Test
    public void rentABookSuccessStatusTest(){
        int bookIDRented = 2;
        book.bookList();
        book.rentABook(bookIDRented);

        for(Book books : book.getBookList()){
            if(books.getId() == bookIDRented){
                assertTrue(books.isRented());
                break;
            }
        }
    }

    @Test
    public void returnABookSuccessStatusTest(){
        int bookIDRented = 2;
        book.bookList();
        book.rentABook(bookIDRented);
        book.returnABook(bookIDRented);

        for(Book books : book.getBookList()){
            if(books.getId() == bookIDRented){
                assertFalse(books.isRented());
                break;
            }
        }
    }
}


