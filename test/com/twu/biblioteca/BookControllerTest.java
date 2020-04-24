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
        BookController bookController = new BookController();
        String libraryNumber = "002-5678";
        String password = "b5678";
        String expectedReturnMessage = "Thank you! Enjoy the Book.";
        assertEquals(expectedReturnMessage, bookController.rentABook(2,bookController.getAll(),libraryNumber, password));
    }

    @Test
    public void rentABookUnavailableMessageTest(){
        BookController bookController = new BookController();
        String libraryNumber = "003-9101";
        String password = "c7891";
        List<Book> list = bookController.getAll();
        String expectedReturnMessage = "Sorry! The book is not available.";
        bookController.rentABook(3, list, libraryNumber, password);
        assertEquals(expectedReturnMessage, bookController.rentABook(3, list,libraryNumber, password));
    }

    @Test
    public void returnABookSuccessMessageTest(){
        BookController bookController = new BookController();
        String libraryNumber = "004-1121";
        String password = "d0111";
        List<Book> list = bookController.getAll();
        String expectedReturnMessage = "Thank you for returning the book.";
        bookController.rentABook(4, list, libraryNumber, password);
        assertEquals(expectedReturnMessage, bookController.returnABook(4, list, libraryNumber, password));
    }

    @Test
    public void invalidBookReturnMessageTest(){
        BookController bookController = new BookController();
        String libraryNumber = "004-1121";
        String password = "d0111";
        List<Book> list = bookController.getAll();
        String expectedReturnMessage = "That is not a valid book to return.";
        assertEquals(expectedReturnMessage, bookController.returnABook(4, list, libraryNumber, password));
    }

    @Test
    public void rentABookSuccessStatusTest(){
        BookController bookController = new BookController();
        String libraryNumber = "005-3141";
        String password = "e2131";
        List<Book> list = bookController.getAll();
        int bookIDRented = 2;
        bookController.rentABook(bookIDRented, list, libraryNumber, password);

        for(Book books : list){
            if(books.getId() == bookIDRented){
                assertTrue(books.isRented());
                break;
            }
        }
    }

    @Test
    public void returnABookSuccessStatusTest(){
        BookController bookController = new BookController();
        List<Book> list = bookController.getAll();
        String libraryNumber = "005-3141";
        String password = "e2131";
        int bookIDRented = 3;
        bookController.rentABook(bookIDRented, list, libraryNumber, password);
        bookController.returnABook(bookIDRented, list, libraryNumber, password);

        for(Book books : list){
            if(books.getId() == bookIDRented){
                assertFalse(books.isRented());
                break;
            }
        }
    }
}


