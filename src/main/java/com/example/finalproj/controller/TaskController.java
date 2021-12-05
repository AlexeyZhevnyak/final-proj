package com.example.finalproj.controller;

import com.example.finalproj.Status;
import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Task;
import com.example.finalproj.model.TaskDTO;
import com.example.finalproj.model.UpdateTaskDto;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.ProjectService;
import com.example.finalproj.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final ProgrammerService programmerService;
    private final ProjectService projectService;

    public TaskController(TaskService taskService, ProgrammerService programmerService,
                          ProjectService projectService) {
        this.taskService = taskService;
        this.programmerService = programmerService;
        this.projectService = projectService;
    }

    @PostMapping("/{id}")
    public String editTask(@ModelAttribute UpdateTaskDto taskDto, @PathVariable String id) {
        Task task = taskService.get(Integer.parseInt(id));
        task.setStatus(Status.valueOf(taskDto.getTaskStatus()));

        Programmer programmer = programmerService.get(taskDto.getProgrammerId());
        task.setExecutor(programmer);
        task.setComments(taskDto.getComments());
        taskService.update(task);

        return "redirect:/project/" + taskDto.getProjectId();
    }

    @PostMapping
    public String addView(Model model, @ModelAttribute UpdateTaskDto updateTaskDto) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setProjectID(updateTaskDto.getProjectId());
        model.addAttribute("taskDTO", taskDTO);
        model.addAttribute("programmers", projectService.get(taskDTO.getProjectID()).getProgrammers());
        return "add-task";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute TaskDTO taskDTO) {
        taskService.save(
            new Task(0, taskDTO.getProjectID(), taskDTO.getTitle(), programmerService.get(taskDTO.getExecutorId()),
                taskDTO.getBegin(), taskDTO.getEnd(), taskDTO.getStatus(), taskDTO.getComments()));
        return "redirect:/project/"+taskDTO.getProjectID();
    }
}
