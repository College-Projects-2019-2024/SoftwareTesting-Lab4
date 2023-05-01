import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;


public class CleanMachineTest {
    CoffeeMachine cm;

    //setting the ingredients then cleaning the machine
    @Test
    public void test1(){
        cm = new CoffeeMachine();

        cm.SetIngredient();

        cm.CleanMachine();
        
        double cmp = cm.GetCoffeePowder();
        double cmw = cm.GetCoffeeWater();
        double cmm = cm.GetCoffeeMilk();

        assertEquals("Error", cmp, 0,0.0);
        assertEquals("Error", cmw, 0,0.0);
        assertEquals("Error", cmm, 0,0.0);
         
         
    }
}
