package br.com.libdolf.gamereview.domain.gateway;

import br.com.libdolf.gamereview.domain.entities.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    Review save(Review review);

    List<Review> findAll();

    Review findById(Long id);
}
