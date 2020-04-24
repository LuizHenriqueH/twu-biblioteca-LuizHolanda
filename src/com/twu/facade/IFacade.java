package com.twu.facade;

import com.twu.biblioteca.Messages;
import com.twu.controller.BookController;
import com.twu.controller.MovieController;

import java.util.Scanner;

public interface IFacade {

    public void start();
    public void optionMenu(Scanner in, Messages messages);

}
