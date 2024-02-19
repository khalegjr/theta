package dev.khaled.theta.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Repository;

import dev.khaled.theta.model.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {

    @Query("SELECT * FROM product")
    List<Product> findAll();
}
