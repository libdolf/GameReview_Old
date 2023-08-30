package br.com.libdolf.gamereview.usecases.review;

import br.com.libdolf.gamereview.core.exceptions.MissingFieldsException;
import br.com.libdolf.gamereview.data.controllers.review.CreateReviewController;
import br.com.libdolf.gamereview.data.gateway.ReviewRepositoryImpl;
import br.com.libdolf.gamereview.data.services.GameService;
import br.com.libdolf.gamereview.domain.entities.Game;
import br.com.libdolf.gamereview.domain.entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CreateReviewUseCase {
    private ReviewRepositoryImpl repository;
    private GameService gameService;
    public Review save(Input input){
        Game game = gameService.getGameById(input.gameId());
        return repository.save(Review.builder()
                        .game(game)
                        .title(input.title())
                        .review(input.review())
                        .rating(input.rating())
                        .publicationDate(LocalDateTime.now())
                .build());
    }

    public record Input(Integer gameId, String title, String review, Integer rating){}
}
