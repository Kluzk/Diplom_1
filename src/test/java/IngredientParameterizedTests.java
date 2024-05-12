import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientParameterizedTests {

    private Ingredient ingredient;

    private IngredientType type;
    private String name;
    private float price;

    public IngredientParameterizedTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Проверка методов класса Ingredient")
    public static Object[][] ingredients() {
        return new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        };
    }

    @Description("Инициализация класса Ingredient тестовыми данными. Тип: {0}, название: {1}, цена: {2}")
    @Before
    public void initTest() {
        ingredient = new Ingredient(type, name, price);
    }

    @Description("Проверка корректного возвращения цены в методе getPrice")
    @Test
    public void checkGetPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }

    @Description("Проверка корректного возвращения названия в методе getName")
    @Test
    public void checkGetName() {
        String expectedName = name;
        assertEquals(expectedName, ingredient.getName());
    }

    @Description("Проверка корректного возвращения типа в методе getType")
    @Test
    public void checkGetType() {
        IngredientType expectedType = type;
        assertEquals(expectedType, ingredient.getType());
    }
}
