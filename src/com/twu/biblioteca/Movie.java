package com.twu.biblioteca;

public class Movie {

    private String title;
    private String director;
    private String year;
    private String rating;
    private boolean isAvailable;

    public Movie(String title, String director, String year, String rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
