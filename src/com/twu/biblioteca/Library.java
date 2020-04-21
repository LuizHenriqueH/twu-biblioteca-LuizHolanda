package com.twu.biblioteca;
import java.util.Scanner;

public class Library {

    public void start(){
        Scanner in = new Scanner(System.in);  //InputStream
        int value;
        Book book = new Book();
        Messages messages = new Messages();
        System.out.println(messages.welcomeMessage);
        book.bookList();

        loop: while (true) {
            try {
                System.out.println(messages.menuOptionMessage);
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
