package br.com.libdolf.gamereview.domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Genre {
    private String name;
    private Set<Game> games = new HashSet<>();
}
