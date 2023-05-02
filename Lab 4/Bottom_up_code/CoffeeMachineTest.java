import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class CoffeeMachineTest {
    CoffeeMachine cm;
    
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
}
