package br.com.libdolf.gamereview.data.datasources;

import br.com.libdolf.gamereview.data.models.ReviewSchema;
import br.com.libdolf.gamereview.domain.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewJpaRepository extends JpaRepository<ReviewSchema, Long> {
}
