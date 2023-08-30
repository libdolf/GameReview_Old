package br.com.libdolf.gamereview.utils;

import br.com.libdolf.gamereview.domain.entities.Game;
import br.com.libdolf.gamereview.domain.entities.Review;

public class ReviewCreator {
    public static Review validReview(){
        return Review.builder()
                .game(new Game())
                .title("Title Test")
                .review("Review Body Test")
                .rating(10)
                .build();
    }

    public static Review validReviewToBeSaved(){
        return Review.builder()
                .game(new Game())
                .title("Title Test2")
                .review("Review Body Test2")
                .rating(9)
                .build();
    }

    public static Review invalidReview(){
        return Review.builder().build();
    }

    public static Review invalidRatingReview(){
        return Review.builder()
                .game(new Game())
                .title("Title Test")
                .review("Review Body Test")
                .rating(100)
                .build();
    }


}
