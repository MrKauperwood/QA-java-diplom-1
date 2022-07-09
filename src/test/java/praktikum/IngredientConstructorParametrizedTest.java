package praktikum;

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
public class IngredientConstructorParametrizedTest {

    private final String name;
    private final Float price;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    public IngredientConstructorParametrizedTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"", 5F}, // Баг, нельзя создать ингридиент с пустыми именем
                {" ", 5F}, // Баг, нельзя создать ингридиент лишь с пробелами в имени
                {"z\\xd0\\", 5F}, // Уточнил бы тут
                {"!№;%:?*():eagle:", 5F}, // Уточнил бы тут по спецсимволам
                {"Cheese", -1F}, // Баг, нельзя задавать отрицательное число
        };
    }

    @Test
    public void checkConstructorForIngredient() {
        exceptionRule.expect(Exception.class);
        new Ingredient(SAUCE, name, price);
    }

}
