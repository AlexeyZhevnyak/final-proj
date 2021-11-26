package com.example.finalproj.controller;

import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final ProgrammerService programmerService;
    private final TaskService taskService;


    public TestController(ProgrammerService programmerService, TaskService taskService) {
        this.programmerService = programmerService;
        this.taskService = taskService;
    }

    @GetMapping
    public String getAll(Model model){
        model.addAttribute("programmers", taskService.getAll());
        return "index";
    }
}
