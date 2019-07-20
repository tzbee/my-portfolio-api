package com.tzbee.portfolioapi.tags;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Tag {
    JAVASCRIPT("JavaScript"),
    JAVA("Java"),
    HTML("HTML"),
    CSS("CSS"),
    HTML5("HTML5"),
    REACT("React"),
    RESPONSIVE("Responsive"),
    EXPRESS_JS("Express.js"),
    NODE_JS("Node.js"),
    WEBPACK("Webpack"),
    SASS("Sass"),
    REDUX("Redux"),
    RESTFUL_API("RESTful API"),
    GITHUB("GitHub"),
    CHROME("Chrome"),
    JQUERY("JQuery"),
    HIBERNATE("Hibernate"),
    POSTGRES_SQL("PostgreSQL"),
    SERVLET("Servlet"),
    BACKBONE_JS("BackboneJS"),
    SOCKET_IO("Socket.io"),
    GAME("Game"),
    GRUNT("Grunt"),
    ALL("*"),
    AI("AI");

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
