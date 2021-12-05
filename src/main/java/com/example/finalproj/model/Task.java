package com.example.finalproj.model;
import com.example.finalproj.Status;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Task implements Serializable {
    private int id;
    private int projectID;
    private String title;
    private Programmer executor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;

    private Status status;
    private String comments;

    public Task(int id, int projectID, String title, Programmer executor, LocalDate begin, LocalDate end,
                Status status, String comments) {
        this.id = id;
        this.projectID = projectID;
        this.title = title;
        this.executor = executor;
        this.begin = begin;
        this.end = end;
        this.status = status;
        this.comments = comments;
    }

    public Task() {
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return id == task.id && projectID == task.projectID && Objects.equals(title,
            task.title) && Objects.equals(executor, task.executor) && Objects.equals(begin,
            task.begin) && Objects.equals(end, task.end) && status == task.status && Objects.equals(
            comments, task.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, projectID, title, executor, begin, end, status, comments);
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
