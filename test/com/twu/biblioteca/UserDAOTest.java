package com.twu.biblioteca;
import com.twu.dao.UserDAO;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class UserDAOTest {

    @Test
    public void userListNotNullTest() {
        UserDAO userDAO = new UserDAO();
        assertNotNull(userDAO.getAll());
    }
}
