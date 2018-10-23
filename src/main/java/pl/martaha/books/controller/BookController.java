package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.martaha.books.entity.Author;
import pl.martaha.books.entity.Book;
import pl.martaha.books.entity.Category;
import pl.martaha.books.entity.Publisher;
import pl.martaha.books.repository.AuthorRepository;
import pl.martaha.books.repository.BookRepository;
import pl.martaha.books.repository.CategoryRepository;
import pl.martaha.books.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, AuthorRepository authorRepository,CategoryRepository categoryRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.publisherRepository = publisherRepository;
    }

    /* Add a book*/

    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "book/add";
        }
        bookRepository.save(book);
        return "redirect:/book/showAll";
    }

    /* show all Books */

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/showAll";
    }

    /* delete Book */

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookRepository.deleteById(id);
        return "book/showAll";
    }


    /* add Author to Book */

    @ModelAttribute("authorsList")
    public Collection<Author> populateAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors;
    }


    /* add Category to Book */
    @ModelAttribute("categoriesList")
    public Collection<Category> populateCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    /* add Publisher to Book */
    @ModelAttribute("publishersList")
    public Collection<Publisher> populatePublishers() {
        List<Publisher> publishers = publisherRepository.findAll();
        return publishers;
    }
}
