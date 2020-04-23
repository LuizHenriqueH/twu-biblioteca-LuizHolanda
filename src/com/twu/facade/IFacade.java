package com.twu.facade;

import com.twu.biblioteca.Messages;
import com.twu.controller.BookController;

import java.util.Scanner;

public interface IFacade {

    public void start();
    public void optionMenu(Scanner in, BookController bookController, Messages messages);

}
