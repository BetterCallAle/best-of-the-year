package org.lessons.exercise.bestoftheyear.model;

import java.time.LocalDate;

public class Movie extends Content{
    private String director;

    //CONSTRUCTOR
    public Movie(long id, String name, LocalDate year, String genre, String director) {
        super(id, name, year, genre);
        this.director = director;
    }

    //GETTER
    public String getDirector() {
        return director;
    }

    //SETTER
    public void setDirector(String director) {
        this.director = director;
    }

    //METHODS
    @Override
    public String toString() {
        return super.toString() + " - " + director;
    }
}
