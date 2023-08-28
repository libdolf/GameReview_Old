package br.com.libdolf.gamereview.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Game {
    private Long id;
    private String name;
    private String platform;
    private Set<Genre> genre = new HashSet<>();
    private Integer rating;

    public Game(Long id, String name, String platform, Set<Genre> genre, Integer rating) {
        this.id = id;
        this.name = name;
        this.platform = platform;
        this.genre = genre;
        this.rating = rating;
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Set<Genre> getGenre() {
        return genre;
    }

    public void setGenre(Set<Genre> genre) {
        this.genre = genre;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    GameSchema toentity(){
        return GameSchema()
    }
}
