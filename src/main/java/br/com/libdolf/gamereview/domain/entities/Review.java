package br.com.libdolf.gamereview.domain.entities;

import br.com.libdolf.gamereview.data.models.ReviewSchema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Review {
    private Long id;
    private Game game;
    private String title;
    private String review;
    private Integer rating;
    private LocalDateTime publicationDate;


    public ReviewSchema toSchema(){
        return new ReviewSchema(
                this.game.getId(),
                this.title,
                this.review,
                this.rating,
                this.publicationDate);
    }
}
