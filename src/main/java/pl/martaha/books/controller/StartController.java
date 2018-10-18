package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    // configuration check
    @GetMapping("/")
    public String home() {
        return "main";
    }
}


