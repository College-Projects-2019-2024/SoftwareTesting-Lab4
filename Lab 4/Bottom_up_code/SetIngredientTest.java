import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class SetIngredientTest {
    CoffeeMachine cm;
    
    @Test
    public void test1(){
        cm = new CoffeeMachine();

        cm.SetIngredient();

        double cmp = cm.GetCoffeePowder();
        double cmw = cm.GetCoffeeWater();
        double cmm = cm.GetCoffeeMilk();

        assertEquals("Error", cmp, 500.0,0.0);
        assertEquals("Error", cmw, 2,0.0);
        assertEquals("Error", cmm, 1,0.0);
         
         
    }
}
