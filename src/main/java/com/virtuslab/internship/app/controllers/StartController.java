package com.virtuslab.internship.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping({"/"})
    public String start(Model model){
        model.addAttribute("start","Virtus Lab shop");
        return "start/start";
    }
}
