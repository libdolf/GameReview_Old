package br.com.libdolf.gamereview.data.models;

import br.com.libdolf.gamereview.domain.entities.Game;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ReviewSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private GameSchema game;

    private String title;

    private String review;

    private Integer rating;

    private LocalDateTime publicationDate;

    public ReviewSchema(Game game, String title, String review, Integer rating, LocalDateTime publicationDate) {
        this.game = game.toEntity();
        this.title = title;
        this.review = review;
        this.rating = rating;
        this.publicationDate = publicationDate;
    }

    public ReviewSchema() {
    }
}
