package praktikum;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static praktikum.IngredientType.SAUCE;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
@RunWith(Parameterized.class)
public class BurgerMoveIngredientParameterizedTest {

    private final static String INGREDIENT_NAME = "Space Workflow";
    private final static float PRICE = 2.0F;

    private final Integer indexFrom;
    private final Integer indexTo;
    private Burger burger;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    public BurgerMoveIngredientParameterizedTest(Integer indexFrom, Integer indexTo) {
        this.indexFrom = indexFrom;
        this.indexTo = indexTo;
    }

    @Parameterized.Parameters(name = "Test data: indexFrom={0}, indexTo={1}")
    public static Object[][] getData() {
        return new Object[][]{
                {0, 2},
                {0, -1},
                {2, 0},
                {-1, 0}
        };
    }

    @Before
    public void init() {
        burger = new Burger();
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
        burger.addIngredient(new Ingredient(SAUCE, INGREDIENT_NAME, PRICE));
    }

    @Test
    public void checkMoveIngredientWithWrongIndex() {
        exceptionRule.expect(IndexOutOfBoundsException.class);
        burger.moveIngredient(indexFrom, indexTo);
    }
}
