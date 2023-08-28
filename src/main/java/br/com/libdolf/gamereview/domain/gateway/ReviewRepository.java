package br.com.libdolf.gamereview.domain.gateway;

import br.com.libdolf.gamereview.domain.entities.Review;

public interface ReviewRepository {

    void save(Review review);

}
