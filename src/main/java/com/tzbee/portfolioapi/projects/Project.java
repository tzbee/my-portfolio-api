package com.tzbee.portfolioapi.projects;

import com.tzbee.portfolioapi.tags.Tag;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(query = "select p from Project p", name = "query_find_all_projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_id")
    private Long id;

    private String name;

    @ElementCollection(targetClass = Tag.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name="project_tags",joinColumns=@JoinColumn(name="project_id"))
    private Set<Tag> tags;

    protected Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Tag... tags) {
        this(name);
        this.tags = new HashSet<>(Arrays.asList(tags));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
