package com.example.finalproj.controller;

import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Project;
import com.example.finalproj.model.UpdateProjectDto;
import com.example.finalproj.model.UpdateTaskDto;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.ProjectService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ProjectService projectService;
    private final ProgrammerService programmerService;

    public AdminController(ProjectService projectService,
                           ProgrammerService programmerService) {
        this.projectService = projectService;
        this.programmerService = programmerService;
    }

    @GetMapping
    public String getView(Model model) {
        model.addAttribute("projects", projectService.getAll());
        model.addAttribute("allProgrammers", programmerService.getAll());
        model.addAttribute("updateProjectDto", new UpdateProjectDto());
        return "projects";
    }

    @PostMapping("/project/{id}/update")
    public String updateProject(@PathVariable String id, @ModelAttribute UpdateProjectDto dto) {
        Project project = projectService.get(Integer.parseInt(id));
        project.setStatus(dto.getProjectStatus());
        projectService.update(project);
        return "redirect:/admin";
    }
}
