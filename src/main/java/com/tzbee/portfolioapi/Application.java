package com.tzbee.portfolioapi;

import com.tzbee.portfolioapi.projects.Project;
import com.tzbee.portfolioapi.projects.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	ProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("===============");
		projectService.addProject(new Project("Hallooo"));
		projectService.addProject(new Project("Hello"));
		projectService.addProject(new Project("Hyaa"));
		List<Project> projects = projectService.getAllProjects();

		for(Project project:projects){
			log.info(project.getName());
		}

		log.info("===============");
	}
}
