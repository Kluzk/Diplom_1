import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTests {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Test
    public void checkGetRecipeWithMock() {

        String expectedReceipt = String.format(
                "(==== sesame bun ====)%n" +
                "= filling pickles =%n" +
                "(==== sesame bun ====)%n" +
                "%n" +
                "Price: 7.500000%n");

        Mockito.when(bun.getPrice()).thenReturn(2.5F);
        Mockito.when(bun.getName()).thenReturn("sesame bun");
        Mockito.when(ingredient.getPrice()).thenReturn(2.5F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("pickles");

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}
