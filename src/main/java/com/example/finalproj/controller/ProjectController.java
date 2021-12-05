package com.example.finalproj.controller;

import com.example.finalproj.Status;
import com.example.finalproj.model.Project;
import com.example.finalproj.model.Task;
import com.example.finalproj.model.UpdateTaskDto;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    private final ProgrammerService programmerService;

    public ProjectController(ProjectService projectService, ProgrammerService programmerService) {
        this.projectService = projectService;
        this.programmerService = programmerService;
    }

    @RequestMapping(value = "/{id}", method = { RequestMethod.GET, RequestMethod.POST })
    public String getProjectView(@PathVariable int id, Model model) {
        Project project = projectService.get(id);
        Map<Status, List<Task>> tasksByStatus = project.getTasks().stream()
            .collect(Collectors.groupingBy(Task::getStatus));
        model.addAttribute("toDo", tasksByStatus.get(Status.TO_DO));
        model.addAttribute("inProgress", tasksByStatus.get(Status.IN_PROGRESS));
        model.addAttribute("done", tasksByStatus.get(Status.DONE));
        model.addAttribute("programmers", projectService.get(id).getProgrammers());

        UpdateTaskDto updateTaskDto = new UpdateTaskDto();
        updateTaskDto.setProjectId(id);
        model.addAttribute("taskForUpdate", updateTaskDto);
        return "project";
    }


}
