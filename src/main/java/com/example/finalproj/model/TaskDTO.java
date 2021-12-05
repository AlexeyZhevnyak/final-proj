package com.example.finalproj.model;

import com.example.finalproj.Status;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TaskDTO {
    private int projectID;
    private String title;
    private int executorId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private Status status;
    private String comments;

    public TaskDTO() {
    }

    public TaskDTO(int projectID, String title, int executorId, LocalDate begin, LocalDate end,
                   Status status, String comments) {
        this.projectID = projectID;
        this.title = title;
        this.executorId = executorId;
        this.begin = begin;
        this.end = end;
        this.status = status;
        this.comments = comments;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getExecutorId() {
        return executorId;
    }

    public void setExecutorId(int executorId) {
        this.executorId = executorId;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
