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

    private String title;

    private String thumbnail;

    private String url;

    @ElementCollection(targetClass = Tag.class)
    @Enumerated(EnumType.STRING)
    @JoinTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    private Set<Tag> tags;

    protected Project() {
    }

    public Project(String title, String thumbnail, String url,Tag... tags) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.url = url;
        this.tags = new HashSet<>(Arrays.asList(tags));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }
}
