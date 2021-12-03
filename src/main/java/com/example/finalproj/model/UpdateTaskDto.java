package com.example.finalproj.model;

public class UpdateTaskDto {
    private int programmerId;
    private String taskStatus;
    private int projectId;

    public UpdateTaskDto(int programmerId, String taskStatus, int projectId) {
        this.programmerId = programmerId;
        this.taskStatus = taskStatus;
        this.projectId = projectId;
    }

    public UpdateTaskDto() {
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(int programmerId) {
        this.programmerId = programmerId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
