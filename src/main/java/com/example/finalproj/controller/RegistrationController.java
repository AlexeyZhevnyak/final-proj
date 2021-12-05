package com.example.finalproj.controller;

import com.example.finalproj.model.Programmer;
import com.example.finalproj.service.ProgrammerService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    private final BCryptPasswordEncoder encoder;
    private final ProgrammerService programmerService;

    public RegistrationController(BCryptPasswordEncoder encoder,
                                  ProgrammerService programmerService) {
        this.encoder = encoder;
        this.programmerService = programmerService;
    }

    @GetMapping
    public String getView(Model model){
        model.addAttribute(new Programmer());
        return "registration";
    }

    @PostMapping
    public String addProgrammer(@ModelAttribute Programmer programmer){
        programmer.setPassword(encoder.encode(programmer.getPassword()));
        programmerService.save(programmer);
        return "redirect:/";
    }
}
