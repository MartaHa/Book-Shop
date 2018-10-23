package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.martaha.books.entity.Author;
import pl.martaha.books.entity.Publisher;
import pl.martaha.books.repository.AuthorRepository;
import pl.martaha.books.repository.PublisherRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/publisher")
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    /* add a Publisher */


    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisher/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publisher/add";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/showAll";

    }

    /* show all Publishers */

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());
        return "publisher/showAll";
    }



    /* update a Publisher */

    @GetMapping("/update/{id}")
    public String updateAuthor(Model model, @PathVariable long id) {
        model.addAttribute("publisher", publisherRepository.findById(id));
        return "publisher/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid Publisher publisher, BindingResult result) {
        if (result.hasErrors()) {
            return "publisher/update";
        }
        publisherRepository.save(publisher);
        return "redirect:/publisher/showAll";

    }

    /* delete Publisher */

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable long id) {
        publisherRepository.deleteById(id);
        return "publisher/showAll";
    }

}




