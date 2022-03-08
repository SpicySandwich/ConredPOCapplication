package com.product.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.Entity.ProductReviews;

@Repository
public interface ReviewRepo extends JpaRepository<ProductReviews, Long>{

}
