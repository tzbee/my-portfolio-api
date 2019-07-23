package com.tzbee.portfolioapi;

import com.tzbee.portfolioapi.projects.Project;
import com.tzbee.portfolioapi.projects.ProjectDAO;
import com.tzbee.portfolioapi.projects.ProjectService;
import com.tzbee.portfolioapi.tags.Tag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ProjectServiceIntegrationTest {

    @TestConfiguration
    static class ProjectServiceTestContextConfiguration{
        @Bean
        public ProjectService projectService(){
            return new ProjectService();
        }
    }

    @Autowired
    private ProjectService projectService;

    @MockBean
    private ProjectDAO projectDAO;


    @Before
    public void init(){
        Project[] projectArr = {new Project("title","thumbnail","url", Tag.JAVA)};
        List<Project> projects = Arrays.asList(projectArr);
        Mockito.when(projectDAO.findAll()).thenReturn(projects);
    }

    @Test
    public void whenGetAllProjects_thenProjectsShouldBeFound(){
        List<Project> projects = projectService.getAllProjects();
        Project[] projectArr = {new Project("title","thumbnail","url", Tag.JAVA)};
        List<Project> expectedProjects = Arrays.asList(projectArr);
        assertThat(projects.equals(expectedProjects)).isTrue();
    }
}
