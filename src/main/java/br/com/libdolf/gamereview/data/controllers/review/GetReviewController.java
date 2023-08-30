package br.com.libdolf.gamereview.data.controllers.review;

import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.usecases.review.GetReviewUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1/review", produces = MediaType.APPLICATION_JSON_VALUE)
public class GetReviewController {
    private GetReviewUseCase useCase;

    @GetMapping
    public ResponseEntity<List<Response>> getAll(){
        List<Review> reviews = useCase.findAll();
        List<Response> response  = new ArrayList<>();
        for (Review review: reviews){
            response.add(new Response(review.getId(),
                    review.getGame().getName(),
                    review.getTitle(),
                    review.getReview(),
                    review.getRating(),
                    review.getPublicationDate()));
        }
        if (response.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    public record Response(
            Long id,
            String gameName,
            String title,
            String review,
            Integer rating,
            LocalDateTime publicationDate){ };
}
