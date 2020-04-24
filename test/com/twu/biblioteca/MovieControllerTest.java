package com.twu.biblioteca;
import com.twu.controller.MovieController;
import com.twu.entity.Movie;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class MovieControllerTest {

    @Test
    public void listMovieNotNullTest() {
        MovieController movieController = new MovieController();
        assertNotNull(movieController.getAll());
    }

    @Test
    public void rentAMovieSuccessMessageTest(){
        MovieController movieController = new MovieController();
        String expectedReturnMessage = "Thank you! Enjoy the Movie.";
        assertEquals(expectedReturnMessage, movieController.rentAMovie(2,movieController.getAll()));
    }

    @Test
    public void rentAMovieUnavailableMessageTest(){
        MovieController movieController = new MovieController();
        List<Movie> list = movieController.getAll();
        String expectedReturnMessage = "Sorry! The movie is not available.";
        movieController.rentAMovie(3, list);
        assertEquals(expectedReturnMessage, movieController.rentAMovie(3, list));
    }

    @Test
    public void returnAMovieSuccessMessageTest(){
        MovieController movieController = new MovieController();
        List<Movie> list = movieController.getAll();
        String expectedReturnMessage = "Thank you for returning the movie.";
        movieController.rentAMovie(4, list);
        assertEquals(expectedReturnMessage, movieController.returnAMovie(4, list));
    }

    @Test
    public void invalidMovieReturnMessageTest(){
        MovieController movieController = new MovieController();
        List<Movie> list = movieController.getAll();
        String expectedReturnMessage = "That is not a valid movie to return.";
        assertEquals(expectedReturnMessage, movieController.returnAMovie(4, list));
    }

    @Test
    public void rentAMovieSuccessStatusTest(){
        MovieController movieController = new MovieController();
        List<Movie> list = movieController.getAll();
        int movieIDRented = 2;
        movieController.rentAMovie(movieIDRented, list);

        for(Movie movie : list){
            if(movie.getId() == movieIDRented){
                assertTrue(movie.isRented());
                break;
            }
        }
    }

    @Test
    public void returnAMovieSuccessStatusTest(){
        MovieController movieController = new MovieController();
        List<Movie> list = movieController.getAll();
        int movieIDRented = 3;
        movieController.rentAMovie(movieIDRented, list);
        movieController.returnAMovie(movieIDRented, list);

        for(Movie movie : list){
            if(movie.getId() == movieIDRented){
                assertFalse(movie.isRented());
                break;
            }
        }
    }
}
