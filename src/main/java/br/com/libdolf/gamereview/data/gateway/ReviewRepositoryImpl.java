package br.com.libdolf.gamereview.data.gateway;

import br.com.libdolf.gamereview.data.datasources.ReviewJpaRepository;
import br.com.libdolf.gamereview.data.models.ReviewSchema;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.domain.gateway.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepository {
    private ReviewJpaRepository reviewJpaRepository;


    @Override
    public Review save(Review review) {
        return reviewJpaRepository.save(review.toSchema()).toEntity();
    }

    @Override
    public List<Review> findAll() {
        List<ReviewSchema> schemas = reviewJpaRepository.findAll();
        List<Review> reviews = new ArrayList<>();
        for(ReviewSchema schema : schemas){
            reviews.add(schema.toEntity());
        }
        return reviews;
    }
}
