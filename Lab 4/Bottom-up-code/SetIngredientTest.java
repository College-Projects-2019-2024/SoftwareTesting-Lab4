import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class SetIngredientTest {
    CoffeeMachine cm;

    //without calling setIngredient
    @Test
    public void test1(){
        cm = new CoffeeMachine();

        double cmp = cm.GetCoffeePowder();
        double cmw = cm.GetCoffeeWater();
        double cmm = cm.GetCoffeeMilk();

        assertEquals("Error", cmp, 0,0.0);
        assertEquals("Error", cmw, 0,0.0);
        assertEquals("Error", cmm, 0,0.0);
         
         
    }

    // calling setIngredient
    @Test
    public void test2(){
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
