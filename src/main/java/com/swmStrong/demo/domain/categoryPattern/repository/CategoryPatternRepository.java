package com.swmStrong.demo.domain.categoryPattern.repository;


import com.swmStrong.demo.domain.categoryPattern.entity.CategoryPattern;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryPatternRepository extends MongoRepository<CategoryPattern, ObjectId>, CustomCategoryPatternRepository {
    boolean existsByCategory(String category);
    void deletePatternCategoryByCategory(String category);
    Optional<CategoryPattern> findByCategory(String category);
}
