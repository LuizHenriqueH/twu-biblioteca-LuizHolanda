package com.twu.dao;
import com.twu.entity.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements DAO<Movie> {

    private List<Movie> movieList;

    @Override
    public List<Movie> getAll() {
        movieList = new ArrayList<Movie>();

        movieList.add(new Movie(1,"Back to the Future",1985,"Robert Zemeckis",8));
        movieList.add(new Movie(2,"Back to the Future - Part 2",1989,"Robert Zemeckis",8));
        movieList.add(new Movie(3,"Back to the Future - Part 3",1989,"Robert Zemeckis",8));
        movieList.add(new Movie(4,"Matrix",1999,"Lana and Lilly Wachowski",8));
        movieList.add(new Movie(5,"Matrix Reloaded",2003,"Lana and Lilly Wachowski",8));
        movieList.add(new Movie(6,"Matrix Revolutions",2003,"Lana and Lilly Wachowski",8));
        movieList.add(new Movie(7,"The Lord of the Rings - The Fellowship of the Ring",2002,"Peter Jackson",8));
        movieList.add(new Movie(8,"The Lord of the Rings - The Two Towers",2002,"Peter Jackson",8));
        movieList.add(new Movie(9,"The Lord of the Rings - The Return of the King",2003,"Peter Jackson",8));
        movieList.add(new Movie(10,"A Nightmare on Elm Street",1985,"Wes Craven",8));
        movieList.add(new Movie(11,"Friday the 13th",1980,"Sean S. Cunningham",8));
        movieList.add(new Movie(12,"Halloween",1978,"John Carpenter",8));

        return movieList;
    }
}
