package com.tzbee.portfolioapi.projects;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectDAO {
    public List<Project> getAllProjects(){
        List<Project> projects = new ArrayList();
        Project project1 = new Project("Project 1");
        Project project2 = new Project("Project 2");
        projects.add(project1);
        projects.add(project2);

        return projects;
    }
}
