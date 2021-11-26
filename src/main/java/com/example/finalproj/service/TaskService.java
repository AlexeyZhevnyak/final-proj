package com.example.finalproj.service;

import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final IDao<Task> dao;

    public TaskService(IDao<Task> dao) {
        this.dao = dao;
    }

    public List<Task> getAll() {
        return dao.getAll();
    }
}
