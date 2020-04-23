package com.twu.facade;

import com.twu.biblioteca.Messages;
import com.twu.controller.BookController;
import com.twu.entity.Book;

import java.util.List;
import java.util.Scanner;

public class Facade implements IFacade{

    private BookController bookController;
    private static Facade uniqueInstanceFacade;

    public static Facade getInstance() {
        if (uniqueInstanceFacade == null)
            uniqueInstanceFacade = new Facade();

        return uniqueInstanceFacade;
    }

    private Facade() {
        bookController = new BookController();
    }

    public void start() {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);  //InputStream
        Messages messages = new Messages();
        System.out.println(messages.welcomeMessage);
        optionMenu(in, bookController, messages);
    }

    public void optionMenu(Scanner in, BookController bookController, Messages messages) {
        int value;
        List<Book> bookList = bookController.getAll();

        loop: while (true) {
            try {
                System.out.println(messages.menuOptionMessage);
                value = in.nextInt();

                switch(value){
                    case 1:
                        for (Book book : bookList) {
                            System.out.println(book.toString());
                        }
                        break;
                    case 2:
                        System.out.println(messages.bookIDMessage);
                        value = in.nextInt();
                        System.out.println(bookController.rentABook(value,bookList));
                        break;
                    case 3:
                        System.out.println(messages.bookIDMessage);
                        value = in.nextInt();
                        System.out.println(bookController.returnABook(value, bookList));
                        break;
                    case 9:
                        System.out.println(messages.exitMessage);
                        break loop;
                    default:
                        System.out.println(messages.optionUnavailable);

                }
            } catch (java.util.InputMismatchException e) {
                System.out.println(messages.unexpectedValueMessage);
                in.next();
            }
        }
    }
}
