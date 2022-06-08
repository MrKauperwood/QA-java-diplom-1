package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Author: Alexey Bondarenko
 * Date: 03.06.2022
 */
@RunWith(Parameterized.class)
public class BunPriceParameterizedTest {

    private final String name;
    private final Float price;

    public BunPriceParameterizedTest(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Parameterized.Parameters(name = "Test data: {0}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Alex", -1F}, //выглядит как баг, отрицательная цена - странно, должна быть проверка на это
                {"Alex", 0F}, // аналогично, возможный баг, я бы уточнил сходил
                {"Alex", 999999999999999F}, // возможный баг, есть смысл ограничить верхнюю сумму для цены
                {"", 9F}, // баг, пустое имя
                {" ", 9F}, // баг, имя не должно содержать пробелов
                {"z\\xd0\\x98\\xcc\\x86\\xcc\\x88y", 9F}, // уточнил бы еще тут
                {"!№;%:?*()", 9F} // уточнил бы еще тут по спецсимволам
        };
    }

    @Test
    public void checkMoveIngredientWithWrongIndex() {
        exceptionRule.expect(Exception.class);
        new Bun(name, price);
    }
}
