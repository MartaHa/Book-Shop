package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.martaha.books.entity.Author;
import pl.martaha.books.repository.AuthorRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    /* adding an  Author */


    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";

    }

    /* show all Authors */

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author/showAll";
    }



    /* update Author */

    @GetMapping("/update/{id}")
    public String updateAuthor(Model model, @PathVariable long id) {
        model.addAttribute("author", authorRepository.findById(id));
        return "author/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/update";
        }
        authorRepository.save(author);
        return "redirect:/author/showAll";

    }
}


