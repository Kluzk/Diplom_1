import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

public class DatabaseTests {

    Database database;

    @Before
    public void initTest(){
        database = new Database();
    }

    @Description("Проверка размера списка Buns, который возвращает метод availableBuns в классе Database")
    @Test
    public void checkBunsSize() {
        int expectedSize = 3;
        assertEquals(expectedSize, database.availableBuns().size());
    }

    @Description("Проверка размера списка Ingredients, который возвращает метод availableIngredients в классе Database")
    @Test
    public void checkIngredientsSize() {
        int expectedSize = 6;
        assertEquals(expectedSize, database.availableIngredients().size());
    }
}
