package com.tzbee.portfolioapi;

import com.tzbee.portfolioapi.projects.Project;
import com.tzbee.portfolioapi.projects.ProjectService;
import com.tzbee.portfolioapi.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	ProjectService projectService;

	@Autowired
	Collection<Project> projects;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (Project project: projects){
			projectService.addProject(project);
		}
	}


}
