package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.martaha.books.entity.User;
import pl.martaha.books.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }



    /* Register as User */

    @GetMapping("/registerUser")
    public String showFormUser(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/registerUser")

    public String perform(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "registerUser";
        }
        userService.saveUser(user, "ROLE_USER");
        return "redirect:/login";

    }

    /* Register as Admin */

    @GetMapping("/registerAdmin")
    public String showFormAdmin(Model model) {
        model.addAttribute("user", new User());
        return "registerAdmin";
    }

    @PostMapping("/registerAdmin")

    public String performAdmin(@ModelAttribute @Valid User user, String role, BindingResult result) {
        if (result.hasErrors()) {
            return "registerAdmin";
        }
        userService.saveUser(user, "ROLE_ADMIN");
        return "redirect:/login";
    }

    /* Login */

    @GetMapping("/login")
    public String Login() {
        return "login";
    }


}
