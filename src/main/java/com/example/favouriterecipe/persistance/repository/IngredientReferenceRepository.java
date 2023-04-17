package com.example.favouriterecipe.persistance.repository;



import com.example.favouriterecipe.persistance.entity.IngredientReferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Ingredient Reference Repository
 *
 * @author Prabu
 */
@Repository
public interface IngredientReferenceRepository extends JpaRepository<IngredientReferenceEntity, Long> {

    /**
     * Fetch matched Ingredient Reference
     *
     * @param name Ingredient name
     * @return matched Ingredient reference
     */
    Optional<IngredientReferenceEntity> findByNameEqualsIgnoreCase(String name);
}
