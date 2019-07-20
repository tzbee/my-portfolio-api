package com.tzbee.portfolioapi.tags;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tag {
    JAVASCRIPT("JavaScript"),
    JAVA("Java"),
    HTML("HTML"),
    CSS("CSS"),
    HTML5("HTML5"),
    REACT("React");

    private String name;

    Tag(String name) {
        this.name = name;
    }

    @JsonValue
    @Override
    public String toString() {
        return name;
    }
}
