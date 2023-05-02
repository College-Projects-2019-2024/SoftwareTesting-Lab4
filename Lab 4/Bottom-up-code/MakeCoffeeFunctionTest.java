
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

   //making black coffee
   @Test
   public void test1()  {
      cm = new CoffeeMachine();
      cm.SetIngredient();
      userInput = "1";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
     
      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int count = cm.GetCoffeeCount();
      Scanner f = new Scanner(System.in);
      cm.makecoffee(f);
      f.close();
      
      double Ecmp = cmp - 10;
      double Ecmw = cmw - 0.2;
      double Ecmm = cmm;
      int Ecount = count + 1;

      assertEquals("Error", Ecmp, cm.GetCoffeePowder(),0.0);
      assertEquals("Error", Ecmw, cm.GetCoffeeWater(),0.0);
      assertEquals("Error", Ecmm, cm.GetCoffeeMilk(),0.0);
      assertEquals("Error", Ecount, cm.GetCoffeeCount());


   }

   //making milk coffee
   @Test
   public void test2() {
      cm = new CoffeeMachine();
      cm.SetIngredient();
      userInput = "2";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
     
      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int count = cm.GetCoffeeCount();
      Scanner f = new Scanner(System.in);
      cm.makecoffee(f);
      f.close();
      double Ecmp = cmp - 10;
      double Ecmw = cmw - 0.2;
      double Ecmm = cmm - 0.4;
      int Ecount = count + 1;

      assertEquals("Error", Ecmp, cm.GetCoffeePowder(),0.0);
      assertEquals("Error", Ecmw, cm.GetCoffeeWater(),0.0);
      assertEquals("Error", Ecmm, cm.GetCoffeeMilk(),0.0);
      assertEquals("Error", Ecount, cm.GetCoffeeCount());
   }

   // case break
   @Test
   public void test3() {
      cm = new CoffeeMachine();
      cm.SetIngredient();
      userInput = "0";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
     
      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int count = cm.GetCoffeeCount();
      Scanner f = new Scanner(System.in);
      cm.makecoffee(f);
      f.close();
      double Ecmp = cmp;
      double Ecmw = cmw;
      double Ecmm = cmm;
      int Ecount = count;

      assertEquals("Error", Ecmp, cm.GetCoffeePowder(),0.0);
      assertEquals("Error", Ecmw, cm.GetCoffeeWater(),0.0);
      assertEquals("Error", Ecmm, cm.GetCoffeeMilk(),0.0);
      assertEquals("Error", Ecount, cm.GetCoffeeCount());
   }
}
