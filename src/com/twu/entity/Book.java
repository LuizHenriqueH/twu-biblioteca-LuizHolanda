package com.twu.entity;

public class Book {

    private int id;
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private boolean rented;

    //constructor
    public Book(int id, String title, String author, String publisher, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        setRented(false);
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

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
