/**
 * 
 */

/**
 * @author linh8
 * version 09042019
 * A simple program that takes in some string inputs and return the length of the string, find the position of the substring and so on
 */
import java.util.Scanner;
public class FunWithStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		
		System.out.print ("Enter a long string: ");
		String longString = keyboard.nextLine();
		System.out.print ("Enter a substring: ");
		String subString = keyboard.nextLine();
		int lengthString = longString.length();
		System.out.println ("Length of your string: " + lengthString);
		int lengthSs = subString.length();
		System.out.println ("Length of your substring: " + lengthSs);
		int startSs = longString.indexOf(subString);
		System.out.println ("Starting position of your substring: " +startSs);
		String before = longString.substring (0, startSs);
		System.out.println ("String before your substring: " + before);
		String after = longString.substring (startSs + lengthSs, lengthString);
		System.out.println ("String after your substring: " + after);
		
		System.out.print ("Enter a position between 0 and " + (lengthString - 1) + ": ");
		String pos = keyboard.nextLine();
		int pos1 = Integer.parseInt(pos);
		
		char charPos = longString.charAt(pos1);
		System.out.println ("The character at position " + pos1 + " is " + charPos);
		System.out.print ("Enter a replacement string: " );
		String replace = keyboard.nextLine();
		String newlong = longString.replace(subString, replace);
		System.out.println ("Your new string is: " + newlong);
		System.out.println ("Goodbye!");
		keyboard.close();
	}

}
