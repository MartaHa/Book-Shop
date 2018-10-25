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
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    /* update User */

    @GetMapping("/update/{id}")
    public String updateAuthor(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.findById(id));
        return "user/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/update";
        }
        userRepository.save(user);
        return "redirect:/user/showUser";

    }

    /* show User */

    @GetMapping("/showUser")

    public String showUser(@AuthenticationPrincipal CurrentUser customUser, Model model) {
        User entityUser = customUser.getUser();
        model.addAttribute("user", entityUser);
        return "user/showUser";

    }




    /* show User by Id*/

    @GetMapping("/showUser/{id}")

    public String showUserbyId(Model model, @PathVariable long id) {
        model.addAttribute("user", userRepository.getOne(id));
        return "user/showUser";

    }

}
