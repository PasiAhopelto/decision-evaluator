package com.example.decisionevaluator.web;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    /** Example htmx endpoint: returns only an HTML fragment that htmx swaps into the page. */
    @GetMapping("/ping")
    public String ping(Model model) {
        model.addAttribute("time", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
        return "fragments/ping :: pong";
    }
}
