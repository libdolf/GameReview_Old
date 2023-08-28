package br.com.libdolf.gamereview.domain.entities;

import br.com.libdolf.gamereview.data.models.ReviewSchema;
import lombok.Data;

import java.time.LocalDateTime;

public class Review {
    private Long id;
    private Game game;
    private String title;
    private String review;
    private Integer rating;
    private LocalDateTime publicationDate;

    public Review(Game game, String title, String review, Integer rating, LocalDateTime publicationDate) {
        this.game = game;
        this.title = title;
        this.review = review;
        this.rating = rating;
        this.publicationDate = publicationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public ReviewSchema toEntity(){
        return new ReviewSchema(
                this.game,
                this.title,
                this.review,
                this.rating,
                this.publicationDate);
    }
}
