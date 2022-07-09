package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;

/**
 * Author: Alexey Bondarenko
 * Date: 01.06.2022
 */
public class IngredientTest {

    private final static String INGREDIENT_NAME = "Space Workflow";
    private final static float PRICE = 2.0F;

    private Ingredient ingredient;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void checkGetPrice() {
        ingredient = new Ingredient(FILLING, INGREDIENT_NAME, PRICE);
        assertEquals(PRICE, ingredient.getPrice(), 0);
    }

    @Test
    public void checkGetName() {
        ingredient = new Ingredient(FILLING, INGREDIENT_NAME, PRICE);
        assertEquals(INGREDIENT_NAME, ingredient.getName());
    }

    @Test
    public void checkGetType() {
        ingredient = new Ingredient(FILLING, INGREDIENT_NAME, PRICE);
        assertEquals(FILLING, ingredient.getType());
    }

    @Test
    public void checkIngredientConstructorIfNameIsNull() { // Баг, не должно быть возможности передать null
        exceptionRule.expect(Exception.class);
        ingredient = new Ingredient(FILLING, null, PRICE);
    }

    @Test
    public void checkIngredientConstructorIfTypeIsNull() { // Баг, не должно быть возможности передать null
        exceptionRule.expect(Exception.class);
        ingredient = new Ingredient(null, INGREDIENT_NAME, PRICE);
    }
}