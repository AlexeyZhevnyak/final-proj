package com.example.finalproj.model;

import com.example.finalproj.ProjectStatus;

public class UpdateProjectDto {
    private int programmerId;
    private ProjectStatus projectStatus;

    public UpdateProjectDto(int programmerId, ProjectStatus projectStatus) {
        this.programmerId = programmerId;
        this.projectStatus = projectStatus;
    }

    public UpdateProjectDto() {
    }

    public int getProgrammerId() {
        return programmerId;
    }

    public void setProgrammerId(int programmerId) {
        this.programmerId = programmerId;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }
}
