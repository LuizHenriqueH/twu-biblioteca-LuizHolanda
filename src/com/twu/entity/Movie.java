package com.twu.entity;

public class Movie {

    private int id;
    private String name;
    private int year;
    private String director;
    private int rating;
    private boolean rented;

    public Movie(int id, String name, int year, String director, int rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        setRented(false);

    }

    public String toString() {

        String toString = "ID: " + this.id +
                " - Name: " + this.name +
                " - Year: " + this.year +
                " - Director: " + this.director +
                " - Movie rating: " + this.rating;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }
}
