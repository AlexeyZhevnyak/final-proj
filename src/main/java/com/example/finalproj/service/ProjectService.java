package com.example.finalproj.service;

import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Project;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final IDao<Project> dao;

    public ProjectService(IDao<Project> dao) {
        this.dao = dao;
    }

    public List<Project> getAll() {
        return dao.getAll();
    }

    public Project get(int parseInt) {
        return dao.get(parseInt);
    }

    public void update(Project project) {
        dao.update(project);
    }
}
