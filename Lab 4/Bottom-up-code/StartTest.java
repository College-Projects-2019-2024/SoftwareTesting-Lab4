import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StartTest {
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
   public void test1(){
    cm = new CoffeeMachine();
    userInput = "1\n6";

    in = new ByteArrayInputStream(userInput.getBytes());
    System.setIn(in);

    cm.start();

    String p1 = " ----------------------------------------------------------------\n"
        + "|                   Coffee Machine By Manikant                   |\n"
        + " ----------------------------------------------------------------\n";

    String p2 = "\nCurrent Status: \n" + "Available Coffee Power(Gram) " + cm.GetCoffeePowder()
        +"\nAvailable Milk(Liter) " + cm.GetCoffeeMilk() + "\nAvailable Water(Liter) " + cm.GetCoffeeWater()
        +"\n";

    String p4 =  "\n -------------------------------- \n"
        + "|1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |"
        + "\n -------------------------------- \n\n\n";

    String p3 = "------------- Status ------------\n" + "Available Coffee Power(Gram) " + cm.GetCoffeePowder()
        +"\nAvailable Milk(Liter) " + cm.GetCoffeeMilk() + "\nAvailable Water(Liter) " + cm.GetCoffeeWater() +
        "\n---------------------------------\n";

    String p5 = "\nExiting...\n";

    String actual = out.toString();

    String expected = p1+p2+p4+p3+p4+p5;

    assertEquals("Error",expected, actual);
   }
}
