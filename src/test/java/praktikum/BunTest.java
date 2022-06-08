package praktikum;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Author: Alexey Bondarenko
 * Date: 01.06.2022
 */
public class BunTest {

    private final static String NAME = "Alexey";
    private final static float PRICE = 8.5F;

    private Bun bun;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void checkConstructorForNameIsNull() {
        exceptionRule.expect(Exception.class);
        bun = new Bun(null, PRICE); //баг, мы не должны давать возможность создавать с null в имени
    }

    @Test
    public void checkGetName() {
        bun = new Bun(NAME, PRICE);
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void checkGetPrice() {
        bun = new Bun(NAME, PRICE);
        assertEquals(PRICE, bun.getPrice(), 0);
    }

}