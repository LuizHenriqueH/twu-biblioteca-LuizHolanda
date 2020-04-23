package com.twu.controller;

import com.twu.dao.BookDAO;
import com.twu.entity.Book;
import com.twu.biblioteca.Messages;

import java.util.List;

public class BookController {

    private final BookDAO bookDAO = new BookDAO();
    Messages messages = new Messages();
    String message = "";

    public List<Book> getAll(){
        return bookDAO.getAll();
    }

    public String rentABook(int IDBook, List<Book> booklist){
        if(IDBook > booklist.size()) return messages.optionUnavailable;

        for(Book book : booklist)
            if (IDBook == book.getId()) if (!book.isRented()) {
                book.setRented(true);
                message = messages.bookRentalSuccessMessage;
            } else {
                message = messages.bookRentalUnavailableMessage;
            }
        return message;
    }

    public String returnABook(int IDBook, List<Book> booklist){
        if(IDBook > booklist.size()) return messages.optionUnavailable;

        for(Book book : booklist)
            if (IDBook == book.getId()) if (book.isRented()) {
                book.setRented(false);
                message = messages.bookReturnSuccessMessage;
            } else {
                message = messages.invalidBookReturnMessage;
            }
        return message;
    }

}
