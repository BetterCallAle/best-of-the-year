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
    @GetMapping()
    public String home(Model model){
        String name = "Alessio";
        model.addAttribute("name", name);
        return "home";
    }
}
