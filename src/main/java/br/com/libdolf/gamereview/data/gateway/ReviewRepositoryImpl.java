package br.com.libdolf.gamereview.data.gateway;

import br.com.libdolf.gamereview.data.datasources.ReviewJpaRepository;
import br.com.libdolf.gamereview.domain.entities.Review;
import br.com.libdolf.gamereview.domain.gateway.ReviewRepository;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepositoryImpl implements ReviewRepository {
    private ReviewJpaRepository reviewJpaRepository;


    @Override
    public void save(Review review) {
        reviewJpaRepository.save(review.toEntity());
    }
}
