/**
 * 
 */

/** Program takes in a number to create an array of that length and then fill in the array with user's inputs.
 * @author linh8
 * version 093019
 */ 
import java.util.Scanner;
public class FillArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean isNegative = false;
		
		while (isNegative == false) {
			System.out.print ("Please enter the number of digits to be stored: ");
			String input = keyboard.nextLine();
			int arrayLength = Integer.parseInt(input);
			if (arrayLength <0) {
				System.out.println ("ERROR! You must enter a non-negative number of digits!");
				System.out.println ();
			}
			else if (arrayLength == 0) {
				isNegative = true;
				System.out.println ("No digits to store? Goodbye!");
			}
			else {
				int [] newArray = new int [arrayLength];
				for (int i = 0; i < arrayLength; i++) {
					System.out.print ("Enter integer " + i +" : ");
					String nums = keyboard.nextLine();
					int num = Integer.parseInt(nums);
					newArray[i] = num;
				}
				isNegative = true;
				System.out.println ();
				System.out.println ("The contents of your array:");
				System.out.println ("Number of digits in array: " + arrayLength);
				System.out.print ("Digits in array:");
				for (int i = 0; i < arrayLength; i++) {
					System.out.print (" " + newArray[i]);
			
				}
			}
		}
		keyboard.close();

	}

}
