package com.twu.biblioteca;
import com.twu.facade.Facade;

public class BibliotecaApp {

    public static void main(String[] args) {
        Facade facade = Facade.getInstance();
        facade.start();
    }
}
