package pl.martaha.books.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.martaha.books.entity.User;
import pl.martaha.books.repository.UserRepository;
import pl.martaha.books.service.CurrentUser;
import pl.martaha.books.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;


    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /* update Admin */

    @GetMapping("/update/{id}")
    public String updateAuthor(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id));
        return "admin/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/update";
        }
        userRepository.save(user);
        return "redirect:/admin/showAdmin";

    }

    /* show Admin */

    @GetMapping("/showAdmin")

    public String showUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "admin/showAdmin";

    }

}
