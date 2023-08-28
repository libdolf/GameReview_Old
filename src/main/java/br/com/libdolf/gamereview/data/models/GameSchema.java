package br.com.libdolf.gamereview.data.models;

import br.com.libdolf.gamereview.domain.entities.Genre;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
public class GameSchema {
    @Id
    private Long id;
    private String name;
    private String platform;
    private Integer rating;
}
