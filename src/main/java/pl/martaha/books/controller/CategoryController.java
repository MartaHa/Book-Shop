package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.martaha.books.entity.Author;
import pl.martaha.books.entity.Category;
import pl.martaha.books.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /* adding a Category */

    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")

    public String SaveCategory(@ModelAttribute @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryRepository.save(category);
        return "redirect:/category/showAll";

    }

    /* show all Categories */

    @GetMapping("/showAll")
    public String showAllCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/showAll";
    }



    /* update Category */

    @GetMapping("/update/{id}")
    public String updateCategory(Model model, @PathVariable long id) {
        model.addAttribute("category", categoryRepository.findById(id));
        return "category/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/update";
        }
        categoryRepository.save(category);
        return "redirect:/category/showAll";

    }

    /* delete Category */

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        categoryRepository.deleteById(id);
        return "category/showAll";
    }

    /* CategoryList */

    @ModelAttribute("CategoriesList")
    List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}




