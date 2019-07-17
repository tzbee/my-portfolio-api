package com.tzbee.portfolioapi.projects;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class ProjectDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Project> findAll() {
        Query query = entityManager.createNamedQuery("query_find_all_projects", Project.class);
        return query.getResultList();
    }

    public long insert(Project project){
        entityManager.persist(project);
        return project.getId();
    }
}
