import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StartTest {
   CoffeeMachine cm;
   private ByteArrayInputStream in;
   private ByteArrayOutputStream out;
   
   private String userInput = "";

   String initial = " ----------------------------------------------------------------\n"
        + "|                   Coffee Machine By Manikant                   |\n"
        + " ----------------------------------------------------------------\n";
    
   String Options =  "\n -------------------------------- \n"
        + "|1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |"
        + "\n -------------------------------- \n\n\n";

   String Current_status = "";

   String Exit = "\nExiting...\n";


   @BeforeEach
   void Init() {
     cm = new CoffeeMachine();

     Current_status = "\nCurrent Status: \n" + "Available Coffee Power(Gram) " + cm.GetCoffeePowder()
        +"\nAvailable Milk(Liter) " + cm.GetCoffeeMilk() + "\nAvailable Water(Liter) " + cm.GetCoffeeWater()
        +"\n";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);

      
   }

   

   // @AfterEach
   // void finish(){
   //    f.close();
   // }


   @Test
   public void test1(){
    userInput = "1\n6";

    in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);
   Scanner f = new Scanner(System.in);
    cm.start(f);
    f.close();
    

    String var = "------------- Status ------------\n" + "Available Coffee Power(Gram) " + cm.GetCoffeePowder()
        +"\nAvailable Milk(Liter) " + cm.GetCoffeeMilk() + "\nAvailable Water(Liter) " + cm.GetCoffeeWater() +
        "\n---------------------------------\n";

    String actual = out.toString();

    String expected = initial+Current_status+Options+var+Options+Exit;

    assertEquals("Error",expected, actual);
   }


   @Test
   public void test2(){
    userInput = "2\n6";

    in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);

    Scanner f = new Scanner(System.in);
    cm.start(f);
    f.close();
    

    String actual = out.toString();

    String var = "\nFilling...\n" + "Filling Completed.\n";

    String expected = initial+Current_status+Options+var+Options+Exit;

    assertEquals("Error",expected, actual);

    double cmp = cm.GetCoffeePowder();
    double cmw = cm.GetCoffeeWater();
    double cmm = cm.GetCoffeeMilk();

    assertEquals("Error", cmp, 500.0,0.0);
    assertEquals("Error", cmw, 2,0.0);
    assertEquals("Error", cmm, 1,0.0);

    
   }

   @Test
   public void test3() {
      userInput = "3\n6";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      Scanner f = new Scanner(System.in);
      cm.start(f);
      f.close();
      

      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();

      assertEquals("Error", cmp, 0.0,0.0);
      assertEquals("Error", cmw, 0,0.0);
      assertEquals("Error", cmm, 0,0.0);

   }

   @Test
   public void test4(){
      userInput = "4\n1\n6";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      cm.SetIngredient();

      double cmp = cm.GetCoffeePowder();
      double cmw = cm.GetCoffeeWater();
      double cmm = cm.GetCoffeeMilk();
      int count = cm.GetCoffeeCount();

      
      Scanner f = new Scanner(System.in);
      cm.start(f);
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

}
