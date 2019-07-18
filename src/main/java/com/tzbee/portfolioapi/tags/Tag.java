package com.tzbee.portfolioapi.tags;


public enum Tag {
    JAVASCRIPT("JavaScript"),
    JAVA("Java"),
    HTML("HTML"),
    CSS("CSS");

    private String name;

    Tag(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
