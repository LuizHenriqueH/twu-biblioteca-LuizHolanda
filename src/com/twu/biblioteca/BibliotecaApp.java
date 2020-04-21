package com.twu.biblioteca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);  //InputStream
        int value;
        Book book = new Book();
        Messages messages = new Messages();
        System.out.println(messages.messageWelcome);
        book.bookList();
        loop: while (true) {
            try {
                System.out.println(messages.menuOptionMessage);
                System.out.println(messages.inputMessage);
                value = in.nextInt();
                switch(value){
                    case 1:
                        for (Book bookArray : book.getBookList()) {
                            System.out.println(bookArray.toString());
                        }
                        break;
                    case 2:
                        System.out.println(messages.bookIDMessage);
                        value = in.nextInt();
                        System.out.println(book.rentABook(value));
                        break;
                    case 3:
                        System.out.println(messages.bookIDMessage);
                        value = in.nextInt();
                        System.out.println(book.returnABook(value));
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
                continue;
            }
        }
    }


}
