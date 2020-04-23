package com.twu.entity;

import com.twu.biblioteca.Messages;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private List<Book> bookList;
    private boolean rented;
    Messages messages = new Messages();

    public Book() { }

    //constructor
    public Book(int id, String title, String author, String publisher, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.setRented(false);
    }

    public String toString() {

        String toString = "ID: " + this.id +
                " - Title: " + this.title +
                " - Author: " + this.author +
                " - Publisher: " + this.publisher +
                " - Publication Year: " + this.publicationYear;

        if (!this.isRented()) {
            toString += " - Available";
        } else {
            toString += " - Unavailable";
        }

        return toString;
    }

    //getters and setters

    public int getId() {
        return id;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

}
