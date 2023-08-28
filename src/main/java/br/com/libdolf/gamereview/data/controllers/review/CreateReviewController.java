package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.libdolf.gamereview.usecases.review.CreateReviewUseCase.Input;
@AllArgsConstructor
@RestController
@RequestMapping(path = "/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreateReviewController {

    private CreateReviewUseCase useCase;

    @PostMapping
    public ResponseEntity create(@RequestBody Request request){
        useCase.save(new Input(request.gameId(),request.title(), request.review(), request.rating()));
        return ResponseEntity.ok().build();
    }

    private record Request(Integer gameId, String title, String review, Integer rating){ }
}
