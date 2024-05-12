import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class BurgerTests {

    private Bun bun;
    private Ingredient sauce;
    private Ingredient filling;
    private Burger burger;

    @Description("Инициализация тестовых данных")
    @Before
    public void initTest() {
        bun = new Bun("black bun", 100);
        sauce = new Ingredient(IngredientType.SAUCE, "sour cream", 200);
        filling = new Ingredient(IngredientType.FILLING, "sausage", 300);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
    }

    @Description("Проверка метода getPrice")
    @Test
    public void checkGetPrice() {
        float expectedPrice = 0;
        for (Ingredient ingredient : burger.ingredients) {
            expectedPrice += ingredient.getPrice();
        }
        expectedPrice += (bun.getPrice() * 2);

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Description("Проверка метода getReceipt")
    @Test
    public void checkGetReceipt() {
        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                "= sauce sour cream =%n" +
                "= filling sausage =%n" +
                "(==== black bun ====)%n" +
                "%n" +
                "Price: 700.000000%n");

        assertEquals(expectedReceipt,  burger.getReceipt());
    }

    @Description("Проверка метода removeIngredient")
    @Test
    public void checkRemoveIngredient() {
        burger.removeIngredient(1);

        assertEquals(1, burger.ingredients.size());
        assertEquals(sauce, burger.ingredients.get(0));
    }

    @Description("Проверка метода moveIngredient")
    @Test
    public void checkMoveIngredient() {
        burger.moveIngredient(0, 1);

        assertEquals(filling, burger.ingredients.get(0));
        assertEquals(sauce, burger.ingredients.get(1));
    }
}