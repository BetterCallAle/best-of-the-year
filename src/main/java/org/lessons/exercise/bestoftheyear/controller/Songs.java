package org.lessons.exercise.bestoftheyear.controller;

import org.lessons.exercise.bestoftheyear.model.Content;
import org.lessons.exercise.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class Songs {
    //SONGS
    @GetMapping()
    public String songs(Model model){
        model.addAttribute("bestSongs", getBestSongs());

        return "songs";
    }

    @GetMapping("/{id}")
    public String songDetails(@PathVariable("id") String songId, Model model){
        List<Content> songs = getBestSongs();
        Content song = null;
        for (int i = 0; i < songs.size() ; i++) {
            if (songs.get(i).getId() == Long.parseLong(songId)){
                song = songs.get(i);
            }
        }

        model.addAttribute("song", song);

        return "song-details";
    }

    //METHODS
    private List<Content> getBestSongs(){
        List<Content> bestSongs = new ArrayList<>();
        bestSongs.add(new Song(22, "Ride", LocalDate.parse("2015-06-10"), "Alt", "Twenty One Pilots"));
        bestSongs.add(new Song(24, "Step", LocalDate.parse("2013-04-22"), "Alt", "Vampire Weekend"));
        bestSongs.add(new Song(2, "Hungry Like The Wolf", LocalDate.parse("1982-09-22"), "Rock", "Duran Duran"));

        return bestSongs;
    }
}
