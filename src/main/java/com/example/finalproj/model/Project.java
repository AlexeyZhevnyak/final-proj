package com.example.finalproj.model;

import com.example.finalproj.ProjectStatus;

import java.util.List;

public class Project {
    private int id;
    private List<Task> tasks;
    private List<Programmer> programmers;
    private ProjectStatus status;
    private int creatorId;

    public Project(int id, List<Task> tasks, List<Programmer> programmers, ProjectStatus status, int creatorId) {
        this.id = id;
        this.tasks = tasks;
        this.programmers = programmers;
        this.status = status;
        this.creatorId = creatorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Programmer> getProgrammers() {
        return programmers;
    }

    public void setProgrammers(List<Programmer> programmers) {
        this.programmers = programmers;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
}
