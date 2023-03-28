package org.lessons.exercise.bestoftheyear.controller;

import org.lessons.exercise.bestoftheyear.model.Content;
import org.lessons.exercise.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class Movies {
    @GetMapping()
    public String movies(Model model){
        model.addAttribute("bestMovies", getBestMovies());

        return "movies";
    }

    @GetMapping("/{id}")
    public String movieDetails(@PathVariable("id") String movieId, Model model){
        List<Content> movies = getBestMovies();
        Content movie = null;
        for (int i = 0; i < movies.size() ; i++) {
            if (movies.get(i).getId() == Long.parseLong(movieId)){
                movie = movies.get(i);
            }
        }

        model.addAttribute("movie", movie);


        return "movie-details";
    }

    //METHODS
    private List<Content> getBestMovies(){
        List<Content> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(1, "Forrest Gump", LocalDate.parse("1994-10-06"), "Drama" ,"Robert Zemeckis"));
        bestMovies.add(new Movie(10, "The Big Lebowski", LocalDate.parse("1998-06-01"), "Comedy", "The Coen Brothers"));

        return bestMovies;
    }
}
