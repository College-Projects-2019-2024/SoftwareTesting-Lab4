import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MakeCoffeeTest {
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
        String userInput = "4";

        in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        
        cm = new CoffeeMachine();
        cm.SetIngredient();
        cm.start();

        

        

        double cmp = cm.GetCoffeePowder(); 
        double cmw = cm.GetCoffeeWater();
        double cmm = cm.GetCoffeeMilk();
        int count = cm.GetCoffeeCount();

        assertEquals("Error", 490, cmp, 0.0);
        assertEquals("Error", 1.8, cmw, 0.0);
        assertEquals("Error", 1, cmm, 0.0);
        assertEquals("Error", 1, count);
        
        userInput= "6";
        in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

    }
}
