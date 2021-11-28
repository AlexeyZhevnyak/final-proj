package com.example.finalproj.controller;

import com.example.finalproj.Status;
import com.example.finalproj.model.Project;
import com.example.finalproj.model.Task;
import com.example.finalproj.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/{id}")
    public String getProjectView(@PathVariable int id, Model model) {
        Project project = projectService.get(id);
        Map<Status, List<Task>> tasksByStatus = project.getTasks().stream()
            .collect(Collectors.groupingBy(Task::getStatus));
        model.addAttribute("toDo", tasksByStatus.get(Status.TO_DO));
        model.addAttribute("inProgress", tasksByStatus.get(Status.IN_PROGRESS));
        model.addAttribute("done", tasksByStatus.get(Status.DONE));
        return "project";
    }
}
