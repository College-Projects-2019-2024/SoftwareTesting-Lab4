import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GetIngredientTest {
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

    //without calling set ingredient
    @Test
    public void test1(){
        cm = new CoffeeMachine();

        cm.GetIngredient();
        String actual = out.toString();
        String expected = "Available Coffee Power(Gram) 0.0\n" + "Available Milk(Liter) 0.0\n"+"Available Water(Liter) 0.0\n";
        
        assertEquals("Error",expected, actual);

    }

    //calling set ingredient
    @Test
    public void test2(){
        cm = new CoffeeMachine();
        cm.SetIngredient();
        cm.GetIngredient();
        String actual = out.toString();
        String expected ="\nFilling...\nFilling Completed.\n" +
          "Available Coffee Power(Gram) 500.0\n" + "Available Milk(Liter) 1.0\n"
        +"Available Water(Liter) 2.0\n";
        
        assertEquals("Error",expected, actual);

    }
}
