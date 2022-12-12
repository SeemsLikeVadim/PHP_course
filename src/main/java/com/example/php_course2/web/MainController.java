package com.example.php_course2.web;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.model.User;
import com.example.php_course2.repository.DeputyRepository;
import com.example.php_course2.repository.UserRepository;
import com.example.php_course2.service.DeputyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private Authentication authentication;

    @Autowired
    DeputyService deputyService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DeputyRepository deputyRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("list",deputyService.getAll());
        return "index";
    }

    @GetMapping("/voteForCandidate/{id}")
    public String voteForCandidate(@PathVariable(value = "id") long id, Model model) {
        authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        deputyService.plusVote(id, email);
        return "redirect:/";
    }


}
