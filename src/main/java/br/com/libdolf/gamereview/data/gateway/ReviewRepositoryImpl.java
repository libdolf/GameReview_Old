package br.com.libdolf.gamereview.data.gateway;

import br.com.libdolf.gamereview.data.datasources.ReviewJpaRepository;
import br.com.libdolf.gamereview.data.models.ReviewSchema;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.domain.gateway.ReviewRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {
    private ReviewJpaRepository reviewJpaRepository;


    @Override
    public Review save(Review review) {
        return reviewJpaRepository.save(review.toSchema()).toEntity();
    }
}
