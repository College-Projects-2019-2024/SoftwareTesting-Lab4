import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class makeCoffeeFunctionTest_2 {
   CoffeeMachine_2 cm;
   private ByteArrayInputStream in;
   private ByteArrayOutputStream out;
   private String userInput = "";

   @BeforeEach
   void Init() {
      cm = new CoffeeMachine_2();
      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);
   }

   @Test
   public void test1() {
      userInput = "1\n6";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      Scanner f = new Scanner(System.in);
      cm.makecoffee_2(f);
      f.close();

      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int cmc = cm.GetCoffeeCount();

      assertEquals("Error", cmp, 490.0, 0.0);
      assertEquals("Error", cmw, 1.8, 0.0);
      assertEquals("Error", cmm, 1, 0.0);
      assertEquals("Error", cmc, 1);

   }

   @Test
   public void test2() {
      userInput = "2\n6";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      Scanner f = new Scanner(System.in);
      cm.makecoffee_2(f);
      f.close();

      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int cmc = cm.GetCoffeeCount();

      assertEquals("Error", cmp, 490.0, 0.0);
      assertEquals("Error", cmw, 1.8, 0.0);
      assertEquals("Error", cmm, 0.6, 0.0);
      assertEquals("Error", cmc, 1);

   }
}
