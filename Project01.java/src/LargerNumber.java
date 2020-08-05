/**
 * Generate a random number and ask for user's input. Then compare the two numbers and return statements.
 * @author LINH NGUYEN
 * @version 992019
 */
import java.util.Scanner;
import java.util.Random;

public class LargerNumber {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter a random seed: ");
        int seed = keyboard.nextInt();
        Random rnd = new Random(seed);
        int computerNum = rnd.nextInt(10) + 1;  // computerNum will be between 1 and 10
        System.out.println("I'm thinking of a number between 1 and 10");
        System.out.print("What is your guess?: ");
        int userNum = keyboard.nextInt();
        System.out.println("My guess was: " + computerNum);
        
        if (userNum> computerNum) {
        	System.out.println("Your number was larger!");
        }
        else {
        	System.out.println("Your number was not larger!");
        }

        keyboard.close();
    }
}