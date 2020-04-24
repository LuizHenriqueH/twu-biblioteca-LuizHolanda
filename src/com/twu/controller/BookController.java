package com.twu.controller;
import com.twu.dao.BookDAO;
import com.twu.entity.Book;
import com.twu.biblioteca.Messages;
import java.util.List;

public class BookController {

    private final BookDAO bookDAO = new BookDAO();
    private UserController userController = new UserController();
    Messages messages = new Messages();
    String message = "";

    public List<Book> getAll(){
        return bookDAO.getAll();
    }

    public String rentABook(int IDBook, List<Book> booklist, String libraryNumber, String password){
        if(IDBook > booklist.size()) return messages.optionUnavailable;

        if(userController.verifyAccount(libraryNumber,password)){
            for(Book book : booklist)
                if (IDBook == book.getId()) if (!book.isRented()) {
                    book.setRented(true);
                    message = messages.bookRentalSuccessMessage;
                } else {
                    message = messages.bookRentalUnavailableMessage;
                }
            return message;
        }else{
            message = messages.credentialsWrong;
        }
        return message;

    }

    public String returnABook(int IDBook, List<Book> booklist, String libraryNumber, String password){
        if(IDBook > booklist.size()) return messages.optionUnavailable;

        if(userController.verifyAccount(libraryNumber,password)) {
            for (Book book : booklist)
                if (IDBook == book.getId()) if (book.isRented()) {
                    book.setRented(false);
                    message = messages.bookReturnSuccessMessage;
                } else {
                    message = messages.invalidBookReturnMessage;
                }
            return message;
        }else{
            message = messages.credentialsWrong;
        }
        return message;
    }

}
