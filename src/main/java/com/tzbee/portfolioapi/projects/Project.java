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
    private Long id;

    private String name;

    @ElementCollection(targetClass = Tag.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    private Set<Tag> tags;

    private String url;
    private String imgURL;

    protected Project() {
    }

    public Project(String name, String url, String imgURL,Tag... tags) {
        this.name = name;
        this.url = url;
        this.imgURL = imgURL;
        this.tags = new HashSet<Tag>(Arrays.asList(tags));
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
