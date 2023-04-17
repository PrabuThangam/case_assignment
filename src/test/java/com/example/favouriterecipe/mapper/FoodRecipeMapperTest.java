package com.example.favouriterecipe.mapper;


import com.example.favouriterecipe.model.FoodRecipe;
import com.example.favouriterecipe.model.Ingredient;
import com.example.favouriterecipe.persistance.entity.FoodRecipeEntity;
import com.example.favouriterecipe.persistance.entity.IngredientReferenceEntity;
import com.example.favouriterecipe.persistance.repository.IngredientReferenceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;


import static com.example.favouriterecipe.enums.DishType.VEGAN;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FoodRecipeMapperTest {

    @Mock private IngredientReferenceRepository referenceRepository;

    @InjectMocks private FoodRecipeMapper foodRecipeMapper;

    @Test
    void formFoodRecipeEntity() {
        IngredientReferenceEntity referenceEntity = new IngredientReferenceEntity();
        referenceEntity.setName("egg");
        when(referenceRepository.findByNameEqualsIgnoreCase("egg")).thenReturn(Optional.of(referenceEntity));
        FoodRecipeEntity recipeEntity = new FoodRecipeEntity();

        foodRecipeMapper.formFoodRecipeEntity(getFoodRecipe(), recipeEntity, 1L);
        verify(referenceRepository, times(0)).save(any());

        assertEquals("Egg fry", recipeEntity.getRecipeName());
        assertEquals(VEGAN, recipeEntity.getDishType());
        assertEquals(Integer.valueOf(4), recipeEntity.getServings());
        assertEquals("Cook me on Stove", recipeEntity.getInstructions());
        assertEquals(Integer.valueOf(2), recipeEntity.getIngredients().get(0).getQuantity());
        assertEquals("egg", recipeEntity.getIngredients().get(0).getReferenceEntity().getName());
        assertNull(recipeEntity.getIngredients().get(0).getUnit());

        //TO Test formFoodRecipeModel from derived entity
        FoodRecipe foodRecipeModel = foodRecipeMapper.formFoodRecipeModel(recipeEntity, true);
        assertEquals("Egg fry", foodRecipeModel.getRecipeName());
        assertEquals(VEGAN, foodRecipeModel.getDishType());
        assertEquals(Integer.valueOf(4), foodRecipeModel.getServings());
        assertEquals("Cook me on Stove", foodRecipeModel.getInstructions());
        assertEquals(Integer.valueOf(2), foodRecipeModel.getIngredients().get(0).getQuantity());
        assertEquals("egg", foodRecipeModel.getIngredients().get(0).getName());
        assertNull(foodRecipeModel.getIngredients().get(0).getUnit());
        assertEquals("2 egg", foodRecipeModel.getIngredientsWithQuantity().get(0));
    }

    @Test
    void formFoodRecipeEntityWithIngredientReferenceNotFound() {
        when(referenceRepository.findByNameEqualsIgnoreCase("egg")).thenReturn(Optional.empty());
        when(referenceRepository.save(any())).thenReturn(new IngredientReferenceEntity());

        FoodRecipeEntity recipeEntity = new FoodRecipeEntity();

        foodRecipeMapper.formFoodRecipeEntity(getFoodRecipe(), recipeEntity, 1L);
        verify(referenceRepository, times(1)).save(any());

        assertEquals(VEGAN, recipeEntity.getDishType());
        assertEquals(Integer.valueOf(4), recipeEntity.getServings());
        assertEquals("Cook me on Stove", recipeEntity.getInstructions());
        assertEquals(Integer.valueOf(2), recipeEntity.getIngredients().get(0).getQuantity());
        assertNotNull(recipeEntity.getIngredients().get(0).getReferenceEntity());
        assertNull(recipeEntity.getIngredients().get(0).getUnit());
    }

    private FoodRecipe getFoodRecipe() {
        FoodRecipe foodRecipe = new FoodRecipe();
        foodRecipe.setRecipeName("Egg fry");
        foodRecipe.setServings(4);
        foodRecipe.setDishType(VEGAN);
        foodRecipe.setInstructions("Cook me on Stove");
        foodRecipe.setIngredients(new ArrayList<>());
        foodRecipe.getIngredients().add(new Ingredient());
        foodRecipe.getIngredients().get(0).setName("egg");
        foodRecipe.getIngredients().get(0).setQuantity(2);
        return foodRecipe;
    }
}
