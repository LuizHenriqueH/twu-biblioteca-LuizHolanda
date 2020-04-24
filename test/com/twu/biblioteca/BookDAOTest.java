package com.twu.biblioteca;
import com.twu.dao.BookDAO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class BookDAOTest {


    @Test
    public void bookListNotNullTest() {
        BookDAO book = new BookDAO();
        assertNotNull(book.getAll());
    }

}
