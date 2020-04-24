package com.twu.controller;
import com.twu.biblioteca.Messages;
import com.twu.dao.UserDAO;
import com.twu.entity.User;
import java.util.List;

public class UserController {

    UserDAO userDAO = new UserDAO();
    Messages messages = new Messages();
    List<User> userList;

    public boolean verifyAccount(String libraryNumber, String password){
        userList = userDAO.getAll();
        boolean registeredAccount = false;

        for(User user : userList){
            if(libraryNumber.equals(user.getLibraryNumber())){
                if(password.equals(user.getPassword())){
                    registeredAccount = true;
                }else{
                    registeredAccount = false;
                }
                break;
            }
        }
        return registeredAccount;
    }

    public User returnUser(String libraryNumber, String password){
        return null;
    }

    public String seeMyInformation(String libraryNumber, String password){
        userList = userDAO.getAll();
        String information = "";
        for(User user : userList){
            if(libraryNumber.equals(user.getLibraryNumber())){
                if(password.equals(user.getPassword())){
                    information = user.toString();
                }else{
                    information = messages.credentialsWrong;
                }
                break;
            }
        }
        return information;
    }

}
