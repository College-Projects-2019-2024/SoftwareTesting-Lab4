import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StartTest_2 {
    CoffeeMachine_2 cm;
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
     cm = new CoffeeMachine_2();

     Current_status = "\nCurrent Status: \n" + "Available Coffee Power(Gram) " + cm.GetCoffeePowder()
        +"\nAvailable Milk(Liter) " + cm.GetCoffeeMilk() + "\nAvailable Water(Liter) " + cm.GetCoffeeWater()
        +"\n";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);

      
   }


   @Test
   public void test1(){
    userInput = "2\n6";

    in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);

    Scanner f = new Scanner(System.in);
    cm.start(f);
    f.close();
    

    double cmp = cm.GetCoffeePowder();
    double cmw = cm.GetCoffeeWater();
    double cmm = cm.GetCoffeeMilk();

    assertEquals("Error", cmp, 500.0,0.0);
    assertEquals("Error", cmw, 2,0.0);
    assertEquals("Error", cmm, 1,0.0);

    
   }
}
