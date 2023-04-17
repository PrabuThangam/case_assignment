package com.example.favouriterecipe.persistance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Ingredient Reference where all references are stored
 *
 * @author Prabu
 */
@Entity
@Table(name = "INGREDIENT_REFERENCE")
public class IngredientReferenceEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;

    /**
     * @return ID of Ingredient reference
     */
    public Long getId() {
        return id;
    }

    /**
     * @return Ingredient name
     */
    public String getName() {
        return name;
    }

    /**
     * @param id of the Ingredient
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param name of the Ingredient
     */
    public void setName(String name) {
        this.name = name;
    }
}
