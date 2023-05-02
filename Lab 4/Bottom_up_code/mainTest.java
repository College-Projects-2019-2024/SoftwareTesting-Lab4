import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class mainTest {
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

   String start = "\nWants to Start Mechine Y or N ?\n";

   


   @BeforeEach
   void Init() {

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);

      Current_status = "\nCurrent Status: \n" + "Available Coffee Power(Gram) 0.0"
        +"\nAvailable Milk(Liter) 0.0" + "\nAvailable Water(Liter) 0.0" 
        +"\n";
   }


   @Test
   void yesTest(){
    userInput = "Y\n2\n6";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      MakeCoffee.main(null);

      String var = "\nFilling...\n" + "Filling Completed.\n";

      String expected = start+initial+Current_status+Options+var+Options+Exit+"Shutting Down...\n\n";
      
      String actual = out.toString();

      assertEquals("Error", expected,actual);
      
   }
        

   @Test
   public void noTest(){
   
      userInput = "N";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      MakeCoffee.main(null);

      String actual = out.toString();
      
      String shut = "Shutting Down...\n\n";

      assertEquals("Error", start+shut, actual);

   }
}

