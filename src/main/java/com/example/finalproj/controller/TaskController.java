package com.example.finalproj.controller;

import com.example.finalproj.Status;
import com.example.finalproj.model.Programmer;
import com.example.finalproj.model.Task;
import com.example.finalproj.model.UpdateTaskDto;
import com.example.finalproj.service.ProgrammerService;
import com.example.finalproj.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final ProgrammerService programmerService;

    public TaskController(TaskService taskService, ProgrammerService programmerService) {
        this.taskService = taskService;
        this.programmerService = programmerService;
    }

    @PostMapping("/{id}")
    public String editTask(@ModelAttribute UpdateTaskDto taskDto, @PathVariable String id) {
        Task task = taskService.get(Integer.parseInt(id));
        task.setStatus(Status.valueOf(taskDto.getTaskStatus()));

        Programmer programmer = programmerService.get(taskDto.getProgrammerId());
        task.setExecutor(programmer);
        taskService.update(task);

        return "redirect:/project/" + taskDto.getProjectId();
    }
}
