/**
 * 
 */

/**Palindrome is a program that takes user's inputs and check whether the input is the same when it is reversed.
 * @author linh8
 * ver 09232019
 */
import java.util.Scanner;
public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		boolean empty = false;
		boolean isPalindrome = false;
		
		
		while (empty == false) { // loop until the input is empty
			System.out.print("Enter a string: ");
			String input = keyboard.nextLine();
			if (input.length()==0) {
				System.out.println ("Empty line read - Goodbye!");
				empty = true;}
			else if (input.length()!=0) {
				for (int i=0; i < input.length(); i++) {
					if (input.charAt(i) != input.charAt(input.length()-1-i)) { // check if the characters at the beginning pos and the end pos are the same
						empty = true;
						isPalindrome = false;
												
					}
					else {
						isPalindrome = true;
									
				}
			}
			if (isPalindrome == true)	{
				System.out.println (input +  " is a palindrome.");
				System.out.println ();
			}
			else {
				System.out.println (input + " is NOT a palindrome.");
				System.out.println ();
			}
				
			}
			
			
			
						
					
		}
		keyboard.close();
	
	

}
}
