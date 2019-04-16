package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieLibrary {

    private ArrayList<Movie> movies;

    public MovieLibrary(ArrayList movies) { this.movies = movies; }

    public String listOfMovies() {
        String movieList = "";
        for(int i = 0; i < movies.size(); i++) {
            if (movies.get(i).isAvailable()) {
                movieList = movieList + (i + 1) + "\t\t" + movies.get(i).getTitle() + "\t\t" + movies.get(i).getDirector() + "\t\t" + movies.get(i).getYear() + "\t\t" + movies.get(i).getRating() + "\n";
            }
        }
        return movieList;
    }

    public Boolean hasMovie(String title) {
        for(Movie movie: movies) {
            if (movie.getTitle().equals(title) && movie.isAvailable()) {
                return true;
            }
        }
        return false;
    }

    public String borrowMovie(String title) {
        for(Movie movie: movies) {
            if (movie.getTitle().equals(title)) {
                movie.setIsAvailable(false);
                listOfMovies();
            }
        }
        return listOfMovies();
    }
}
