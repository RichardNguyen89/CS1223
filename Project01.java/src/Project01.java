/**
 * 
 */

/**
 * @author linh8
 * version 08292019
 * A simple arithmetic program takes in 2 integers and returns some simple calculations.
 */
import java.util.Scanner;
public class Project01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in); // Create scanner object
		int number1 = keyboard.nextInt();
		int number2 = keyboard.nextInt();
		
		int sum = number1 + number2;
		int sub = number1 - number2;
		int mul = number1 * number2;
		int div = number1 / number2;
		int mod = number1 % number2;
		int avg = (number1 + number2) / 2;
		
		System.out.print ("Enter the first number: " );
		System.out.print ("Enter the second number: " );
		System.out.println (number1 + " + " + number2 + " = " + sum);
		System.out.println (number1 + " - " + number2 + " = " + sub);
		System.out.println (number1 + " * " + number2 + " = " + mul);
		System.out.println (number1 + " / " + number2 + " = " + div);
		System.out.println (number1 + " % " + number2 + " = " + mod);
		System.out.println ("The average of your two numbers is: " + avg );
		
	}

}
