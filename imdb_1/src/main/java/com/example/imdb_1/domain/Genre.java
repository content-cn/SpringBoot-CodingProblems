package com.example.imdb_1.domain;

import org.springframework.stereotype.Component;

@Component
public class Genre {
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}
