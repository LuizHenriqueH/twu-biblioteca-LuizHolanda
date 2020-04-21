package com.twu.biblioteca;

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

    public Book() {
        this.setRented(false);
    }

    //constructor
    public Book(int id, String title, String author, String publisher, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.setRented(false);
    }

    public void bookList(){
        bookList = new ArrayList();

        bookList.add(new Book(1,"Harry Potter and the Philosopher's Stone", "J.K. Rowling","Rocco", 1997 ));
        bookList.add(new Book(2,"Harry Potter and the Chamber of Secrets", "J.K. Rowling","Rocco", 1998 ));
        bookList.add(new Book(3,"Harry Potter and the Prisoner of Azkaban", "J.K. Rowling","Rocco", 1999 ));
        bookList.add(new Book(4,"Harry Potter and the Goblet of Fire", "J.K. Rowling","Rocco", 2000 ));
        bookList.add(new Book(5,"Harry Potter and the Order of the Phoenix", "J.K. Rowling","Rocco", 2003 ));
        bookList.add(new Book(6,"Harry Potter and the Half-Blood Prince", "J.K. Rowling","Rocco", 2005 ));
        bookList.add(new Book(7,"Harry Potter and the Deathly Hallows", "J.K. Rowling","Rocco", 2007 ));

        bookList.add(new Book(8,"The Lord of the Rings - The Fellowship of the Ring", "J.R.R. Tolkien","Allen & Unwin", 1954 ));
        bookList.add(new Book(9,"The Lord of the Rings - The Two Towers", "J.R.R. Tolkien","Allen & Unwin", 1954 ));
        bookList.add(new Book(10,"The Lord of the Rings - The Return of the King", "J.R.R. Tolkien","Allen & Unwin", 1955 ));
    }

    public String rentABook(int IDBook){
        String message = "";
        for(Book book : getBookList()) {
            if(IDBook == book.getId()){
                if(!book.isRented()){
                    book.setRented(true);
                    message = messages.bookRentalSucessMessage;
                }else{
                    message = messages.bookRentalUnavailableMessage;
                }
            }
        }

        return message;
    }

    public String returnABook(int IDBook){
        String message = "";
        for(Book book : getBookList()) {
            if(IDBook == book.getId()){
                if(!book.isRented()){
                    book.setRented(false);
                    message = messages.bookReturnSucessMessage;
                }else{
                    message = messages.invalidBookReturnMessage;
                }
            }
        }
        return message;
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
