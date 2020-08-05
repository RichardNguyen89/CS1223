/**
 * 
 */

/** Program uses the LuhnAlgorithm to check whether a creditcard is ligitimate
 * @author linh8
 * ver 1012019
 */

import java.util.Scanner;

public class LuhnAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean stop = false;
				
		while (stop == false) {
			System.out.print("Enter a credit card number (enter a blank line to quit): ");
			String input = keyboard.nextLine();
			int sum = 0;
			
			if (input.length() == 0) {
				System.out.println ("Goodbye!");
				stop = true;
			}
			else {
				int checkDigit = Integer.parseInt(input.substring(input.length()-1, input.length()));
				if (input.length() != 16) {
					System.out.println ("ERROR! Number MUST have exactly 16 digits.");
					
				}
				else if (input.length() == 16) {
					for (int i = input.length()-2; i >-1;i--) {
						String s = input.substring(i,i+1);
						int val = Integer.parseInt(s);
						if (i%2==0) {
							val = val*2;
							if (val > 9) {
								val = val-9;
							}
							}
						sum = sum + val;
				}
				int finalCheck;
				if (sum%10 == 0) {
					finalCheck = 0;
				}
				else {
					finalCheck = 10 - sum%10; 
				}
				
				System.out.println ("Check digit should be: "+ finalCheck);
				System.out.println ("Check digit is: "+ checkDigit);
				if ( finalCheck == checkDigit ) {				
					System.out.println ("Number is valid.");}
				else {
					System.out.println("Number is not valid.");}
				
				}
				System.out.println ();
				}
			}
		keyboard.close();	
		}
}
			
	

