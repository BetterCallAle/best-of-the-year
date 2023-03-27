package org.lessons.exercise.bestoftheyear.controller;

import org.lessons.exercise.bestoftheyear.model.Content;
import org.lessons.exercise.bestoftheyear.model.Movie;
import org.lessons.exercise.bestoftheyear.model.Song;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class Home {

    //HOME
    @GetMapping()
    public String home(Model model){
        String name = "Alessio";
        model.addAttribute("name", name);
        return "home";
    }

    //MOVIES
    @GetMapping("/movies")
    public String movies(Model model){
        String bestMovies = "";
        List<Content> movies = getBestMovies();

        for (Content movie : movies){
            bestMovies += movie.getName() + ", ";
        }

        bestMovies = bestMovies.substring(0, bestMovies.length()-2);
        model.addAttribute("bestMovies", bestMovies);

        return "movies";
    }

    @GetMapping("/movies/{id}")
    public String movieDetails(@PathVariable("id") String movieId, Model model){
        List<Content> movies = getBestMovies();
        Content movie = null;
        for (int i = 0; i < movies.size() ; i++) {
            if (movies.get(i).getId() == Long.parseLong(movieId)){
                movie = movies.get(i);
            }
        }

        if(movie != null){
            model.addAttribute("movie", movie);
        } else {
            model.addAttribute("movie", "Non sono stati trovati film");
        }

        return "movie-details";
    }

    //SONGS
    @GetMapping("/songs")
    public String songs(Model model){
        String bestSongs = "";
        List<Content> songs = getBestSongs();

        for (Content song : songs){
            bestSongs += song.getName() + ", ";
        }

        bestSongs = bestSongs.substring(0, bestSongs.length()-2);
        model.addAttribute("bestSongs", bestSongs);

        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String songDetails(@PathVariable("id") String songId, Model model){
        List<Content> songs = getBestSongs();
        Content song = null;
        for (int i = 0; i < songs.size() ; i++) {
            if (songs.get(i).getId() == Long.parseLong(songId)){
                song = songs.get(i);
            }
        }

        if(song != null){
            model.addAttribute("song", song);
        } else {
            model.addAttribute("song", "Non sono state trovate canzoni");
        }

        return "song-details";
    }

    //METHODS
    private List<Content> getBestMovies(){
        List<Content> bestMovies = new ArrayList<>();
        bestMovies.add(new Movie(1, "Forrest Gump", LocalDate.parse("1994-10-06"), "Drama" ,"Robert Zemeckis"));
        bestMovies.add(new Movie(10, "The Big Lebowski", LocalDate.parse("1998-06-01"), "Comedy", "The Coen Brothers"));

        return bestMovies;
    }

    private List<Content> getBestSongs(){
        List<Content> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(22, "Ride", LocalDate.parse("2015-06-10"), "Alt", "Twenty One Pilots"));
        bestSongs.add(new Song(24, "Step", LocalDate.parse("2013-04-22"), "Alt", "Vampire Weekend"));
        bestSongs.add(new Song(2, "Hungry Like The Wolf", LocalDate.parse("1982-09-22"), "Rock", "Duran Duran"));

        return bestSongs;
    }
}
