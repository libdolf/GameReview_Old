package br.com.libdolf.gamereview.data.models;

import br.com.libdolf.gamereview.domain.entities.Game;
import br.com.libdolf.gamereview.domain.entities.Review;
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

    private Long gameId;

    private String title;

    private String review;

    private Integer rating;

    private LocalDateTime publicationDate;

    public ReviewSchema(Long gameId, String title, String review, Integer rating, LocalDateTime publicationDate) {
        this.gameId = gameId;
        this.title = title;
        this.review = review;
        this.rating = rating;
        this.publicationDate = publicationDate;
    }

    public ReviewSchema() {
    }

    public Review toEntity() {
        return  Review.builder()
                .id(getId())
                .title(getTitle())
                .review(getReview())
                .rating(getRating())
                .publicationDate(getPublicationDate())
                .build();
    }
}
