package com.twu.biblioteca;
import com.twu.controller.UserController;
import com.twu.dao.UserDAO;
import com.twu.entity.User;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class UserControllerTest {

    @Test
    public void verifyAccountSuccessTest(){
        UserController userController = new UserController();
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.getAll();
        String libraryNumber = "005-3141";
        String password = "e2131";
        Assert.assertTrue(userController.verifyAccount(libraryNumber, password));
    }

    @Test
    public void verifyAccountFailTest(){
        UserController userController = new UserController();
        UserDAO userDAO = new UserDAO();
        List<User> list = userDAO.getAll();
        String libraryNumber = "005-3141";
        String password = "e21389";
        Assert.assertFalse(userController.verifyAccount(libraryNumber, password));
    }

    @Test
    public void seeMyInformationSuccessTest(){
        UserController userController = new UserController();
        String expectedResult = "Library Number: 001-1234 - Name: Peter Jackson - Email: peterjackson@gmail.com - PhoneNumber: (81)99999-9999";
        String libraryNumber = "001-1234";
        String password = "a1234";
        Assert.assertEquals(expectedResult,userController.seeMyInformation(libraryNumber,password));
    }

    @Test
    public void seeMyInformationFailTest(){
        UserController userController = new UserController();
        String expectedResult = "Incorrect credentials";
        String libraryNumber = "001-1234";
        String password = "a12345";
        Assert.assertEquals(expectedResult,userController.seeMyInformation(libraryNumber,password));
    }

}
