package com.example.finalproj.service;

import com.example.finalproj.model.IDao;
import com.example.finalproj.model.Programmer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammerService {
    private final IDao<Programmer> dao;

    public ProgrammerService(IDao<Programmer> dao) {
        this.dao = dao;
    }

    public List<Programmer> getAll() {
        return dao.getAll();
    }

    public Programmer get(int id) {
        return dao.get(id);
    }

    public void update(Programmer programmer) {
        dao.update(programmer);
    }
}
