    
import java.util.Scanner;
class CoffeeMachine{
static Scanner scan = new Scanner(System.in);
    private double coffee_powder, milk, water;
    private int Coffee_Count = 0;
    public CoffeeMachine(){ //Default Constructor Initialization...
        this.coffee_powder=0;
        this.milk=0;
        this.water=0;
    }
    public int GetCoffeeCount() {return this.Coffee_Count;}
    public double GetCoffeePowder() {return this.coffee_powder; }
    public double GetCoffeeMilk() {return this.milk;}
    public double GetCoffeeWater() {return this.water;}

    public void SetIngredient(){   //Calling for Filling Ingredient...
        System.out.print("\nFilling..."+"\n");
        this.coffee_powder = 500.0;
        this.milk = 1;
        this.water= 2;
        System.out.print("Filling Completed."+"\n");
    }
    public void GetIngredient(){   //To Get Status
            System.out.print("Available Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder)+"\n");
            System.out.print("Available Milk(Liter) "+String.format("%.1f", this.milk)+"\n");
            System.out.print("Available Water(Liter) "+String.format("%.1f", this.water)+"\n");
    }
    public void CleanMachine(){    //Initialization with Null In order to Clean Machine
        System.out.println("\nCleaning Machine...");
        this.coffee_powder = 0;
        this.milk = 0;
        this.water= 0;
        System.out.println("Cleaning Completed.");
    }
    public void makecoffee(){  //Coffee Selection Menu
        System.out.println("\n ------------------ ");
        System.out.println("|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |");
        System.out.println(" ------------------ \n");
        Scanner s = new Scanner(System.in);
        char t = s.nextLine().charAt(0);
        switch(t){
            case '1':
                this.BlackCoffee();     //Call to BlackCoffee Method
                break;
            case '2':
                this.MilkCoffee();      //Call to MilkCoffee Method
                break;
            case '0':
                break;
        }
        s.close();
    }
    public void BlackCoffee(){
        if(this.coffee_powder >= 10 && this.water >= 0.2){
            System.out.println("\nMaking Black Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Black Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void MilkCoffee(){
        if(this.coffee_powder >= 10 && this.milk >= 0.4 && this.water >= 0.2){
            System.out.println("\nMaking Milk Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.4 Liter of Milk.");
            this.milk = this.milk - 0.4;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Milk Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void start(){    //public Start to accese all private method of this class
        System.out.print(" ----------------------------------------------------------------\n");
        System.out.print("|                   Coffee Machine By Manikant                   |\n");
        System.out.print(" ----------------------------------------------------------------\n");
        //System.out.println("Currently We Have Following Operations, Select as your Need:- ");
        System.out.print("\nCurrent Status: \n");
        this.GetIngredient();
        boolean t = true;
        Scanner s = new Scanner(System.in);
        while(t){
            System.out.print("\n -------------------------------- \n");
            System.out.print("|1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |\n");
            System.out.print(" -------------------------------- \n\n\n");
            char c = s.nextLine().charAt(0);
            switch(c){
                case '1': 
                    System.out.print("------------- Status ------------\n");
                    this.GetIngredient();
                    System.out.print("---------------------------------\n");
                    break;
                case '2':
                    this.SetIngredient();
                    break;
                case '3':
                    this.CleanMachine();
                    break;
                case '4':
                    this.makecoffee();
                    break;
                case '5':
                    System.out.println("\nWe Have Made "+this.Coffee_Count+" Coffees.");
                    break;
                case '6':
                    System.out.print("\nExiting...\n");
                    t = false;
                    break;
            }   
        }
        s.close(); 
    }
}
public class MakeCoffee{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nWants to Start Mechine Y or N ?");
        char d;
        d = scan.next().charAt(0);
        if(d == 'Y' || d == 'y'){
            CoffeeMachine cm = new CoffeeMachine();     //Instances For CoffeMachine
            cm.start();     //In order to call All Private Method Calling Public mathod
            System.out.println("Shutting Down...\n");
        }else
            System.out.println("Shutting Down...\n");
        scan.close();
    }
}