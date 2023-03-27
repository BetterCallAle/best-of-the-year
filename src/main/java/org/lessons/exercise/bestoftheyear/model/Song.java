package org.lessons.exercise.bestoftheyear.model;

import java.time.LocalDate;

public class Song extends Content{
    private String band;

    //CONSTRUCTOR
    public Song(long id, String name, LocalDate year, String genre, String band) {
        super(id, name, year, genre);
        this.band = band;
    }

    //GETTER
    public String getBand() {
        return band;
    }

    //SETTER
    public void setBand(String band) {
        this.band = band;
    }

    //METHODS

    @Override
    public String toString() {
        return super.toString() + " - " + band;
    }
}
