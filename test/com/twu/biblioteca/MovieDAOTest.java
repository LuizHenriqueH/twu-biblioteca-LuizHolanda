package com.twu.biblioteca;
import com.twu.dao.MovieDAO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class MovieDAOTest {

    @Test
    public void movieListNotNullTest() {
        MovieDAO movieDAO = new MovieDAO();
        assertNotNull(movieDAO.getAll());
    }
}
