import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunParameterizedTests {

    private Bun bun;

    private String name;
    private float price;

    public BunParameterizedTests(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameters(name = "Проверка методов класса Bun. Тест метода getName возвращает название {0}, тест метода getPrice возвращает цену {1}.")
    public static Object[][] buns() {
        return new Object[][]{
                {"black bun", 100},
                {"white bun", 200},
                {"red bun", 300}
        };
    }

    @Description("Инициализация класса Bun тестовыми данными. Название: {0}, цена: {1}")
    @Before
    public void initTest() {
        bun = new Bun(name, price);
    }

    @Description("Проверка корректного возвращения названия в методе getName")
    @Test
    public void checkGetName() {
        String expectedName = name;
        assertEquals(expectedName, bun.getName());
    }

    @Description("Проверка корректного возвращения цены в методе getPrice")
    @Test
    public void checkGetPrice() {
        float expectedPrice = price;
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }
}
