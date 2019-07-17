package com.tzbee.portfolioapi.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {

    @Autowired
    ProjectDAO projectDAO;

    public List<Project> getAllProjects() {
        return projectDAO.findAll();
    }

    public long addProject(Project project){
        return projectDAO.insert(project);
    }

}
