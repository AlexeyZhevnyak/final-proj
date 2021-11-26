package com.example.finalproj.model;
import com.example.finalproj.Status;

import java.time.LocalDate;
import java.util.List;

public class Task {
    private int id;
    private int projectID;
    private String title;
    private Programmer executor;
    private LocalDate begin;
    private LocalDate end;
    private Status status;
    private List<String> comments;

    public Task(int id, int projectID, String title, Programmer executor, LocalDate begin, LocalDate end,
                Status status, List<String> comments) {
        this.id = id;
        this.projectID = projectID;
        this.title = title;
        this.executor = executor;
        this.begin = begin;
        this.end = end;
        this.status = status;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Programmer getExecutor() {
        return executor;
    }

    public void setExecutor(Programmer executor) {
        this.executor = executor;
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

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", projectID=" + projectID +
            ", title='" + title + '\'' +
            ", executor=" + executor +
            ", begin=" + begin +
            ", end=" + end +
            ", status=" + status +
            ", comments=" + comments +
            '}';
    }
}
