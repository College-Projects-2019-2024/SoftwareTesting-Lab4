
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MakeCoffeeFunctionTest {
   CoffeeMachine cm;
   private ByteArrayInputStream in;
   private ByteArrayOutputStream out;
   private String userInput = "";

   @BeforeEach
   void Init() {
      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);
   }

   @Test
   public void test1() {
      cm = new CoffeeMachine();
      cm.SetIngredient();
      userInput = "1";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int count = cm.GetCoffeeCount();

      cm.makecoffee();

      double Ecmp = cmp - 10;
      double Ecmw = cmw - 0.2;
      double Ecmm = cmm;
      int Ecount = count + 1;

      double c = cm.GetCoffeePowder();

      assertEquals("Error", Ecmp, cm.GetCoffeePowder(),0.0);
      assertEquals("Error", Ecmw, cm.GetCoffeeWater(),0.0);
      assertEquals("Error", Ecmm, cm.GetCoffeeMilk(),0.0);
      assertEquals("Error", Ecount, cm.GetCoffeeCount());


   }

   @Test
   public void test2() {

   }
}
