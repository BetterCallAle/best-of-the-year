package org.lessons.exercise.bestoftheyear.model;

import java.time.LocalDate;

public class Content {
    private long id;
    private String name;
    private LocalDate year;
    private String genre;

    //CONSTRUCTOR
    public Content(long id, String name, LocalDate year, String genre){
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
    }

    //GETTERS
    public String getName() {
        return name;
    }

    public LocalDate getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //METHODS

    @Override
    public String toString() {
        return name + " - " + genre + " - " + year.getYear();
    }
}
