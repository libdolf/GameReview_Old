package br.com.libdolf.gamereview.usecases.review;

import br.com.libdolf.gamereview.data.controllers.review.CreateReviewController;
import br.com.libdolf.gamereview.data.gateway.ReviewRepositoryImpl;
import br.com.libdolf.gamereview.domain.entities.Game;
import br.com.libdolf.gamereview.domain.entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateReviewUseCase {
    private ReviewRepositoryImpl repository;
    public void save(Input input) {
        Game game = gameService.findById(input.gameId());
        repository.save(new Review(game, input.title(), input.review(), input.rating(), LocalDateTime.now()));
    }

    public record Input(Integer gameId, String title, String review, Integer rating){}
}
