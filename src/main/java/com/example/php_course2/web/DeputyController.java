package com.example.php_course2.web;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.service.DeputyService;

import com.example.php_course2.web.dto.DeputyDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deputy")
public class DeputyController {
    private final DeputyService deputyService;

    public DeputyController(DeputyService deputyService) {
        this.deputyService = deputyService;
    }

    @GetMapping
    public String deputy(Model m) {
        m.addAttribute("list", deputyService.getAll());
        return "deputy";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeputy(@PathVariable(value = "id") long id) {
        deputyService.deleteDeputyById(id);
        return "redirect:/deputy";
    }

    @GetMapping("/newVote")
    public String newVote() {
        deputyService.deleteAll();
        return "redirect:/deputy";
    }

    @GetMapping("/newDeputy")
    public String addDeputyForm(Model model) {
        model.addAttribute("deputy", new DeputyDto());
        return "new_deputy";
    }

    @PostMapping("/saveDeputy")
    public String addDeputy(@ModelAttribute(value = "deputy") DeputyDto deputyDto) {
        deputyService.save(deputyDto);
        return "redirect:/deputy/newDeputy?success";
    }

    @GetMapping("/update/{id}")
    public String updateDeputy(@PathVariable(value = "id") long id, Model model) {
        Deputy deputy = deputyService.findById(id);
        DeputyDto deputyDto = new DeputyDto(deputy.getName(), deputy.getParty(), deputy.getVotes(), deputy.getId());
        model.addAttribute("deputy", deputyDto);
        return "update_deputy";
    }

    @PostMapping("/updateDeputy")
    public String updateDeputy(@ModelAttribute(value = "deputy") DeputyDto deputyDto) {
        deputyService.updateDeputy(deputyDto);
        return "redirect:/deputy/update/" + deputyDto.getId() + "?success";
    }

    @GetMapping("/whoVote/{id}")
    public String whoVotePage(Model m, @PathVariable(value = "id") long id) {
        m.addAttribute("list", deputyService.whoVote(id));
        return "who_vote";
    }
}
