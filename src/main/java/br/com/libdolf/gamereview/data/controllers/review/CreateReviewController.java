package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.core.exceptions.MissingFieldsException;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase.Input;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateReviewController {

    private CreateReviewUseCase useCase;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Request request){
        Review review = useCase.save(new Input(request.gameId(),request.title(), request.review(), request.rating()));
        if(review.isEmpty()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }else return new ResponseEntity(HttpStatus.CREATED);
    }

    public record Request(
            @NotNull Integer gameId,
            String title,
            String review,
            Integer rating){ }
}
