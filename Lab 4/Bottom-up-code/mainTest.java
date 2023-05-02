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


   @BeforeEach
   void Init() {

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);
      out = new ByteArrayOutputStream();
      PrintStream print = new PrintStream(out);
      System.setOut(print);
   }


//    @Test
//    void yesTest(){
//     userInput = "Y\n2\n\n6";

//       in = new ByteArrayInputStream(userInput.getBytes());
//       System.setIn(in);
//    }
        

   @Test
   public void noTest(){
    
    MakeCoffee.main(null);
    
    userInput = "N";

      in = new ByteArrayInputStream(userInput.getBytes());
      System.setIn(in);

      String actual = out.toString();

      String shut = "Shutting Down...";

      assertEquals("Error", shut, actual);

   }
}

