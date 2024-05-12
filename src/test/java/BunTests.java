import io.qameta.allure.Description;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTests {

    private Bun bun;

    @Before
    public void initTest() {
        bun = new Bun("Кунжутная", 7.5F);
    }

    @Description("Проверка корректного возвращения названия в методе getName")
    @Test
    public void checkGetName() {
        String expectedName = "Кунжутная";
        assertEquals(expectedName, bun.getName());
    }

    @Description("Проверка корректного возвращения цены в методе getPrice")
    @Test
    public void checkGetPrice() {
        float expectedPrice = 7.5F;
        assertEquals(expectedPrice, bun.getPrice());
    }
}
