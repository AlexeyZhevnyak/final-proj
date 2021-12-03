package com.example.finalproj.controller;

import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Project;
import com.example.finalproj.model.Task;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.ProjectService;
import com.example.finalproj.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

@Controller(value = "/")
public class MainController {
    private final ProgrammerService programmerService;
    private final TaskService taskService;
    private final ProjectService projectService;

    public MainController(ProgrammerService programmerService, TaskService taskService,
                          ProjectService projectService) {
        this.programmerService = programmerService;
        this.taskService = taskService;
        this.projectService = projectService;
    }

    @GetMapping
    public String getProjects(Model model, HttpSession session) {
        session.setAttribute("currentUserId", 5);
        Programmer currentUser = programmerService.get((int) session.getAttribute("currentUserId"));

        List<Project> projects = projectService.getAll()
            .stream()
            .filter(project -> {
                List<Programmer> programmers = project.getProgrammers()
                    .stream()
                    .filter(programmer -> programmer.getLogin().equals(currentUser.getLogin()))
                    .collect(Collectors.toList());
                return !programmers.isEmpty();
            })
            .collect(Collectors.toList());
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            List<Task> projectTasksByCurrUser = project.getTasks().stream()
                .filter(task -> task.getExecutor().getId() == currentUser.getId())
                .collect(Collectors.toList());
            project.setTasks(projectTasksByCurrUser);
        }
        model.addAttribute("projects", projects);
        return "project-list";
    }
}
