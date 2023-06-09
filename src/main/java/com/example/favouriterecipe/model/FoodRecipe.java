package com.example.favouriterecipe.model;


import com.example.favouriterecipe.enums.DishType;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Food Recipe Rest Model
 *
 * @author Prabu
 */
@Schema(description = "Food Recipe with all ingredients and instructions")
public class FoodRecipe extends RepresentationModel<FoodRecipe> {

    @Schema(description = "Name of recipe")
    @NotNull
    @Size(min = 1, max = 200)
    private String recipeName;

    @Schema(description = "The Dish Type of recipe")
    @NotNull
    private DishType dishType;

    @Schema(description = "Number of servings")
    @NotNull
    private Integer servings;

    @NotNull
    @Size(min = 1, max = 100)
    @Schema(description = "List of Ingredients needed for recipe")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Ingredient> ingredients;

    @Size(min = 1, max = 100)
    @Schema(description = "List of Ingredients with measurements needed for recipe. Only in GET")
    private List<String> ingredientsWithQuantity;

    @NotNull
    @Size(max = 2000)
    @Schema(description = "Detailed Instructions needed to prepare recipe")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String instructions;

    /**
     * Get Dish type
     *
     * @return dish type
     */
    public DishType getDishType() {
        return dishType;
    }


    /**
     * Get number of servings
     *
     * @return number of servings
     */
    public Integer getServings() {
        return servings;
    }

    /**
     * Get ingredients for recipe
     *
     * @return ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Get ingredients with quantity
     *
     * @return ingredients with quantity
     */
    public List<String> getIngredientsWithQuantity() {
        return ingredientsWithQuantity;
    }

    /**
     * Get fod recipe instructions
     *
     * @return instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Get recipe name
     *
     * @return recipe name
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Set recipe name
     *
     * @param recipeName recipe name
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Set dish type of food
     *
     * @param dishType dish type of food
     */
    public void setDishType(DishType dishType) {
        this.dishType = dishType;
    }

    /**
     * Set number of servings
     *
     * @param servings number of servings
     */
    public void setServings(Integer servings) {
        this.servings = servings;
    }

    /**
     * Set all required ingredients for recipe
     *
     * @param ingredients all ingredients for recipe
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Set all required ingriendts with quantity for food recipe in single String
     *
     * @param ingredientsWithQuantity all ingredients with required quantity in single String
     */
    public void setIngredientsWithQuantity(List<String> ingredientsWithQuantity) {
        this.ingredientsWithQuantity = ingredientsWithQuantity;
    }


    /**
     * Set instructions for food recipe
     *
     * @param instructions instructions for food recipe
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
