package com.tzbee.portfolioapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.tzbee.portfolioapi.projects.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

@Configuration
public class Projects {

    @Bean
    public Collection<Project> getProjects() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            InputStream fileStream = Projects.class.getResourceAsStream("/projects.yaml");
            Collection<Project> projects = mapper.readValue(fileStream, new TypeReference<Collection<Project>>(){});
            return projects;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.EMPTY_SET;
        }
    }
}
