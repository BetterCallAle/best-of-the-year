package org.lessons.exercise.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
