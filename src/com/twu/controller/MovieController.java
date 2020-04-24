package com.twu.controller;
import com.twu.biblioteca.Messages;
import com.twu.dao.MovieDAO;
import com.twu.entity.Movie;
import java.util.List;

public class MovieController {

    private final MovieDAO movieDAO = new MovieDAO();
    Messages messages = new Messages();
    String message = "";

    public List<Movie> getAll(){
        return movieDAO.getAll();
    }

    public String rentAMovie(int IDMovie, List<Movie> movieList){
        if(IDMovie > movieList.size()) return messages.optionUnavailable;

        for(Movie movie : movieList)
            if (IDMovie == movie.getId()) if (!movie.isRented()) {
                movie.setRented(true);
                message = messages.movieRentalSuccessMessage;
            } else {
                message = messages.movieRentalUnavailableMessage;
            }
        return message;
    }

    public String returnAMovie(int IDMovie, List<Movie> movieList){
        if(IDMovie > movieList.size()) return messages.optionUnavailable;

        for(Movie movie : movieList)
            if (IDMovie == movie.getId()) if (movie.isRented()) {
                movie.setRented(false);
                message = messages.movieReturnSuccessMessage;
            } else {
                message = messages.invalidMovieReturnMessage;
            }
        return message;
    }
}
