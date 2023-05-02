import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class BlackCoffeeTest {
    CoffeeMachine cm;
    
    @Test
    public void test1(){
         cm = new CoffeeMachine();
         cm.SetIngredient();

         double cmp = cm.GetCoffeePowder();
         double cmw = cm.GetCoffeeWater();
         double cmm = cm.GetCoffeeMilk();
         int count = cm.GetCoffeeCount();

         cm.BlackCoffee();

         double Ecmp = cmp - 10;
         double Ecmw = cmw - 0.2;
         double Ecmm = cmm;
         int Ecount = count + 1;

         assertEquals("Error", Ecmp, cm.GetCoffeePowder(),0.0);
         assertEquals("Error", Ecmw, cm.GetCoffeeWater(),0.0);
         assertEquals("Error", Ecmm, cm.GetCoffeeMilk(),0.0);
         assertEquals("Error", Ecount, cm.GetCoffeeCount());

    }
}
