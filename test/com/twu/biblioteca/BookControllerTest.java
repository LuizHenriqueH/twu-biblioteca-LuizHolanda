package com.twu.biblioteca;
import com.twu.controller.BookController;
import com.twu.entity.Book;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BookControllerTest {

    @Test
    public void listBookNotNullTest() {
        BookController book = new BookController();
        assertNotNull(book.getAll());
    }

    @Test
    public void rentABookSuccessMessageTest(){
        BookController book = new BookController();
        String expectedReturnMessage = "Thank you! Enjoy the Book.";
        assertEquals(expectedReturnMessage, book.rentABook(2,book.getAll()));
    }

    @Test
    public void rentABookUnavailableMessageTest(){
        BookController book = new BookController();
        List<Book> list = book.getAll();
        String expectedReturnMessage = "Sorry! The book is not available.";
        book.rentABook(3, list);
        assertEquals(expectedReturnMessage, book.rentABook(3, list));
    }

    @Test
    public void returnABookSuccessMessageTest(){
        BookController book = new BookController();
        List<Book> list = book.getAll();
        String expectedReturnMessage = "Thank you for returning the book.";
        book.rentABook(4, list);
        assertEquals(expectedReturnMessage, book.returnABook(4, list));
    }

    @Test
    public void invalidBookReturnMessageTest(){
        BookController book = new BookController();
        List<Book> list = book.getAll();
        String expectedReturnMessage = "That is not a valid book to return.";
        assertEquals(expectedReturnMessage, book.returnABook(4, list));
    }

    @Test
    public void rentABookSuccessStatusTest(){
        BookController book = new BookController();
        List<Book> list = book.getAll();
        int bookIDRented = 2;
        book.rentABook(bookIDRented, list);

        for(Book books : list){
            if(books.getId() == bookIDRented){
                assertTrue(books.isRented());
                break;
            }
        }
    }

    @Test
    public void returnABookSuccessStatusTest(){
        BookController book = new BookController();
        List<Book> list = book.getAll();
        int bookIDRented = 2;
        book.rentABook(bookIDRented, list);
        book.returnABook(bookIDRented, list);

        for(Book books : list){
            if(books.getId() == bookIDRented){
                assertFalse(books.isRented());
                break;
            }
        }
    }
}


