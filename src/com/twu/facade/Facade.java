package com.twu.facade;

import com.twu.biblioteca.Messages;
import com.twu.controller.BookController;
import com.twu.controller.MovieController;
import com.twu.controller.UserController;
import com.twu.entity.Book;
import com.twu.entity.Movie;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Facade implements IFacade{

    private BookController bookController;
    private MovieController movieController;
    private UserController userController;
    private static Facade uniqueInstanceFacade;

    public static Facade getInstance() {
        if (uniqueInstanceFacade == null)
            uniqueInstanceFacade = new Facade();

        return uniqueInstanceFacade;
    }

    private Facade() {
        bookController = new BookController();
        movieController = new MovieController();
        userController = new UserController();
    }

    public void start() {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);  //InputStream
        Messages messages = new Messages();
        System.out.println(messages.welcomeMessage);
        optionMenu(in, messages);
    }

    public void optionMenu(Scanner in, Messages messages) {
        int value;
        List<Book> bookList = bookController.getAll();
        List<Movie> movieList = movieController.getAll();

        loop: while (true) {
            try {
                System.out.println(messages.menuOptionMessage);
                value = in.nextInt();

                switch(value){
                    case 1:
                        bookList.forEach(book -> System.out.println(book.toString()));
                        break;
                    case 2:
                        rentABook(in, messages, bookList);
                        break;
                    case 3:
                        returnABook(in, messages, bookList);
                        break;
                    case 4:
                        movieList.forEach(movie->System.out.println(movie.toString()));
                        break;
                    case 5:
                        rentAMovie(in, messages, movieList);
                        break;
                    case 6:
                        returnAMovie(in, messages, movieList);
                        break;
                    case 7:
                        seeUserInformation(in, messages);
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

    private void seeUserInformation(Scanner in, Messages messages) {
        String libraryNumber;
        String password;
        System.out.println(messages.inputLibraryNumber);
        libraryNumber = in.next();
        System.out.println(messages.inputPassword);
        password = in.next();
        System.out.println(userController.seeMyInformation(libraryNumber, password));
    }

    private void returnAMovie(Scanner in, Messages messages, List<Movie> movieList) {
        int value;
        System.out.println(messages.movieIDMessage);
        value = in.nextInt();
        System.out.println(movieController.returnAMovie(value, movieList));
    }

    private void rentAMovie(Scanner in, Messages messages, List<Movie> movieList) {
        int value;
        System.out.println(messages.movieIDMessage);
        value = in.nextInt();
        System.out.println(movieController.rentAMovie(value,movieList));
    }

    private void returnABook(Scanner in, Messages messages, List<Book> bookList) {
        int value;
        String libraryNumber;
        String password;
        System.out.println(messages.bookIDMessage);
        value = in.nextInt();
        System.out.println(messages.inputLibraryNumber);
        libraryNumber = in.next();
        System.out.println(messages.inputPassword);
        password = in.next();
        System.out.println(bookController.returnABook(value, bookList, libraryNumber, password));
    }

    private void rentABook(Scanner in, Messages messages, List<Book> bookList) {
        int value;
        String libraryNumber;
        String password;
        System.out.println(messages.bookIDMessage);
        value = in.nextInt();
        System.out.println(messages.inputLibraryNumber);
        libraryNumber = in.next();
        System.out.println(messages.inputPassword);
        password = in.next();
        System.out.println(bookController.rentABook(value,bookList, libraryNumber, password));
    }
}
