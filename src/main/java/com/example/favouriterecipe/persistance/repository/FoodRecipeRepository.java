package com.example.favouriterecipe.persistance.repository;


import com.example.favouriterecipe.persistance.entity.FoodRecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Food Recipe Repository
 *
 * @author Prabu
 */
@Repository
public interface FoodRecipeRepository extends JpaRepository<FoodRecipeEntity, Long> {
}
