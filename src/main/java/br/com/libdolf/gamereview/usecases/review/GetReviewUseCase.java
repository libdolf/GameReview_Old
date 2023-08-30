package br.com.libdolf.gamereview.usecases.review;

import br.com.libdolf.gamereview.data.gateway.ReviewRepositoryImpl;
import br.com.libdolf.gamereview.domain.entities.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetReviewUseCase {
    private ReviewRepositoryImpl repository;
    public List<Review> findAll() {
        return repository.findAll();
    }

    public Review findById(Long id) throws Exception {
        return repository.findById(id);
    }
}
