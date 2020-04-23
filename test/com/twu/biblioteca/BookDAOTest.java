package com.twu.biblioteca;

import com.twu.controller.BookController;
import com.twu.dao.BookDAO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class BookDAOTest {


    @Test
    public void listBookNotNullTest() {
        BookDAO book = new BookDAO();
        assertNotNull(book.getAll());
    }

}
